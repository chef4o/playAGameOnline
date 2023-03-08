package com.example.pago.services.init;

import com.example.pago.services.country.CountryService;
import com.example.pago.services.game.GameService;
import com.example.pago.services.town.TownService;
import com.example.pago.services.user.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DatabaseInitServiceImpl implements DatabaseInitService {
    private final CountryService countryService;
    private final TownService townService;
    private final GameService gameService;
    private final UserService userService;

    @Autowired
    public DatabaseInitServiceImpl(CountryService countryService, TownService townService, GameService gameService, UserService userService) {
        this.countryService = countryService;
        this.townService = townService;
        this.gameService = gameService;
        this.userService = userService;
    }

    @PostConstruct
    public void postConstruct() throws IOException {
        dbImport();
    }

    @Override
    public void dbImport() throws IOException {
        if (!dbExists()) {
            this.countryService.dbImport();
            this.townService.dbImport();
            this.gameService.dbImport();
            this.userService.dbImport();
        }
    }

    @Override
    public boolean dbExists() {
        return this.countryService.dbExists()
                && this.townService.dbExists()
                && this.gameService.dbExists()
                && this.userService.dbExists();
    }

    @Override
    public String readFileContent() throws IOException {
        return null;
    }
}
