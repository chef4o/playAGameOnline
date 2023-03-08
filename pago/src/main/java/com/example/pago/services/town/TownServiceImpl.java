package com.example.pago.services.town;

import com.example.pago.domains.dto.models.seed.TownSeedDto;
import com.example.pago.domains.entities.Country;
import com.example.pago.domains.entities.Town;
import com.example.pago.repositories.CountryRepository;
import com.example.pago.repositories.TownRepository;
import com.example.pago.utils.validation.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static com.example.pago.constant.filePaths.TOWNS_JSON_FILE;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, CountryRepository countryRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.townRepository = townRepository;
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void dbImport() throws IOException {
        if (!dbExists()) {
            Arrays.stream(gson.fromJson(readFileContent(), TownSeedDto[].class))
                    .filter(validationUtil::isValid)
                    .map(townSeedDto -> {
                        Town town = modelMapper.map(townSeedDto, Town.class);
                        Country country = countryRepository.findByName(townSeedDto.getCountry());
                        town.setCountry(country);
                        return town;
                    })
                    .forEach(townRepository::saveAndFlush);
        }
    }

    @Override
    public boolean dbExists() {
        return townRepository.count() > 0;
    }

    @Override
    public String readFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_JSON_FILE));
    }

    @Override
    public Town getTownByName(String name) {
        return this.townRepository.findByName(name);
    }
}
