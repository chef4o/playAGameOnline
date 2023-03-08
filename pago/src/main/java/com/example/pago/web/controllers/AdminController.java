package com.example.pago.web.controllers;

import com.example.pago.domains.dto.views.UserAdminViewDto;
import com.example.pago.domains.enums.Role;
import com.example.pago.services.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.example.pago.constant.keyValues.*;

@Controller
@RequestMapping("/admin-panel")
public class AdminController extends BaseController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public AdminController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ModelAndView getAdminPanel(ModelAndView modelAndView,
                                      HttpSession session) {

        UserAdminViewDto currentUser = getUser(Long.valueOf(session.getAttribute(USER_ID).toString()));
        checkForAdminRights(currentUser);

        modelAndView.addObject(LOWER_LEVEL_USERS, userService
                .getUsersWithLowerRoleThan(currentUser.getRole()));

        modelAndView.addObject(POSSIBLE_ROLES, userService
                .getRolesLowerThan(currentUser.getRole()));

        return super.view("admin-panel", modelAndView);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditAdminPanel(ModelAndView modelAndView,
                                          @PathVariable String id,
                                          HttpSession session) {

        UserAdminViewDto currentUser = getUser(Long.valueOf(session.getAttribute(USER_ID).toString()));
        checkForAdminRights(currentUser);

        modelAndView.addObject(LOWER_LEVEL_USERS, userService
                .getUsersWithLowerRoleThan(currentUser.getRole()));

        modelAndView.addObject(POSSIBLE_ROLES, userService
                .getRolesLowerThan(currentUser.getRole()));

        UserAdminViewDto user = getUser(Long.valueOf(id));

        modelAndView.addObject(USER_TO_EDIT,user);

        return super.view("admin-panel", modelAndView);
    }

    private UserAdminViewDto getUser(Long id) {
        return userService
                .getById(id)
                .map(user -> modelMapper.map(user, UserAdminViewDto.class))
                .orElse(null);
    }

    private void checkForAdminRights(UserAdminViewDto user) {
        if (user == null || !user.hasAdminRights()) {
            super.redirect("/error");
        }
    }
}
