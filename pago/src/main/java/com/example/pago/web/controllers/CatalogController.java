package com.example.pago.web.controllers;

import com.example.pago.domains.entities.Game;
import com.example.pago.services.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController extends BaseController {
    private final GameService gameService;

    @Autowired
    public CatalogController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ModelAndView getCatalog(ModelAndView modelAndView) {
        List<Game> allGames = gameService.getAllGames();
        modelAndView.addObject("games", allGames);
        return super.view("catalog", modelAndView);
    }
}
