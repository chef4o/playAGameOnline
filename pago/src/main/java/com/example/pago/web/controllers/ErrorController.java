package com.example.pago.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.example.pago.constant.keyValues.ERROR_CODE;

@Controller
@RequestMapping("/error")
public class ErrorController extends BaseController {

    @GetMapping()
    public String handleError(ModelAndView modelAndView,
                              @RequestParam(ERROR_CODE) String errorCode) {
        modelAndView.addObject(ERROR_CODE, errorCode);
        return "error";
    }
}
