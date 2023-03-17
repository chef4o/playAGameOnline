package com.example.pago.services.game;

import com.example.pago.domains.dto.models.seed.GameSeedDto;
import com.example.pago.domains.entities.Game;
import com.example.pago.repositories.GameRepository;
import com.example.pago.utils.validation.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static com.example.pago.constant.filePaths.GAMES_JSON_FILE;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.gameRepository = gameRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void dbImport() throws IOException {
        if (!dbExists()) {
            Arrays.stream(gson.fromJson(readFileContent(), GameSeedDto[].class))
                    .filter(validationUtil::isValid)
                    .map(gameSeedDto -> modelMapper.map(gameSeedDto, Game.class))
                    .forEach(gameRepository::saveAndFlush);
        }
    }

    @Override
    public boolean dbExists() {
        return gameRepository.count() > 0;
    }

    @Override
    public String readFileContent() throws IOException {
        return Files.readString(Path.of(GAMES_JSON_FILE));
    }

    public List<Game> getAllGames() {
        return gameRepository.findAllByOrderByRatingDesc();
    }

    public List<Game> getTop4ByRating() {
        return gameRepository.findTop4ByOrderByRatingDesc();
    }
}
