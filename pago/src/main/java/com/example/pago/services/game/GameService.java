package com.example.pago.services.game;

import com.example.pago.domains.entities.Game;
import com.example.pago.services.init.DatabaseInitService;

import java.util.List;

public interface GameService extends DatabaseInitService {
    List<Game> getAllGames();
    List<Game> getTop5ByRating();
}
