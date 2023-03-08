package com.example.pago.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/403")
public class ErrorController extends BaseController {

    @GetMapping()
    public ModelAndView get403(ModelMapper modelMapper) {
        return super.view("403");
    }
}
