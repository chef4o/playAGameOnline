package com.example.pago.web.controllers;

import com.example.pago.domains.dto.bindings.UserLoginDto;
import com.example.pago.domains.dto.bindings.UserRegisterDto;
import com.example.pago.domains.dto.models.UserDto;
import com.example.pago.services.user.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.example.pago.constant.keyValues.*;

@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView,
                                    @ModelAttribute(USER_REGISTER_INFO)
                                    UserRegisterDto userRegisterInfo) {

        modelAndView.addObject("genders", userService.getAllGenders());
        modelAndView.addObject(USER_REGISTER_INFO, userRegisterInfo);

        return super.view("register", modelAndView);
    }

    @PostMapping("/register")
    public ModelAndView postRegister(HttpSession session,
                                     @Valid @ModelAttribute UserRegisterDto userRegisterInfo,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute(USER_REGISTER_INFO, userRegisterInfo)
                    .addFlashAttribute("org.springframework.validation.BindingResult." + USER_REGISTER_INFO,
                            bindingResult);

            return super.redirect("/auth/register");
        }

        UserDto registeredUser = this.userService.registerUser(userRegisterInfo);
        session.setAttribute(USER_ID, registeredUser.getId());
        return super.redirect("/");
    }

    @GetMapping("/login")
    public ModelAndView getLogin(ModelAndView modelAndView,
                                 @ModelAttribute(USER_LOGIN_INFO)
                                 UserLoginDto userLoginInfo) {

        modelAndView.addObject("userLogin", new UserLoginDto());
        modelAndView.addObject(USER_LOGIN_INFO, userLoginInfo);

        return super.view("login", modelAndView);
    }

    @PostMapping("/login")
    public ModelAndView postLogin(HttpSession session,
                                  @Valid @ModelAttribute UserLoginDto userLoginInfo,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute(USER_LOGIN_INFO,userLoginInfo)
                    .addFlashAttribute("org.springframework.validation.BindingResult." + USER_LOGIN_INFO,
                            bindingResult);

            return super.redirect("/auth/login");
        }

        UserDto loggedInUser = this.userService.loginUser(userLoginInfo);

        if (!loggedInUser.exists()) {
            session.invalidate();
            return super.redirect("/auth/login");
        }

        session.setAttribute(USER_ID, loggedInUser.getId());
        return super.redirect("/");
    }

    @PostMapping("/logout")
    public ModelAndView postLogout(HttpSession session) {
        this.userService.logout(session);
        return super.redirect("/");
    }

    //Model attribute
    @ModelAttribute(name = USER_REGISTER_INFO)
    public UserRegisterDto userRegisterDto() {
        return new UserRegisterDto();
    }

    @ModelAttribute(name = USER_LOGIN_INFO  )
    public UserLoginDto userLoginDto() {
        return new UserLoginDto();
    }
}
