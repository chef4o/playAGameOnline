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
@RequestMapping("/")
public class HomeController extends BaseController {

    private final GameService gameService;

    @Autowired
    public HomeController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ModelAndView getHome(ModelAndView modelAndView) {
        List<Game> topGames = gameService.getTop4ByRating();
        modelAndView.addObject("topGames", topGames);

        return super.view("index", modelAndView);
    }
}
