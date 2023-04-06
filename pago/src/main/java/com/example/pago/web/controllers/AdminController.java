package com.example.pago.web.controllers;

import com.example.pago.domains.dto.views.UserAdminViewDto;
import com.example.pago.services.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
        if (accessIsForbidden(modelAndView, currentUser)) return super.redirect("/error");

        enrichWithDataForAllManageableUsers(modelAndView, currentUser);

        return super.view("admin-panel", modelAndView);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditAdminPanel(ModelAndView modelAndView,
                                          @PathVariable Long id,
                                          HttpSession session) {

        UserAdminViewDto currentUser = getUser(Long.valueOf(session.getAttribute(USER_ID).toString()));
        if (accessIsForbidden(modelAndView, currentUser)) return super.redirect("/error");

        enrichWithDataForAllManageableUsers(modelAndView, currentUser);
        importUserForEdit(modelAndView, id);

        return super.view("admin-panel", modelAndView);
    }

    @PatchMapping("/edit/{id}")
    @ResponseBody
    public UserAdminViewDto updateUser(@PathVariable Long id,
                                       @RequestBody UserAdminViewDto user,
                                       HttpSession session) {

        UserAdminViewDto currentUser = getUser(Long.valueOf(session.getAttribute(USER_ID).toString()));
        hasAdminRights(currentUser);

        return userService.updateUser(id, user);
    }

    private UserAdminViewDto getUser(Long id) {
        return userService
                .getById(id)
                .map(user -> modelMapper.map(user, UserAdminViewDto.class))
                .orElse(null);
    }

    private boolean hasAdminRights(UserAdminViewDto user) {
        return user != null && user.hasAdminRights();
    }

    private boolean accessIsForbidden(ModelAndView modelAndView, UserAdminViewDto currentUser) {
        if (!hasAdminRights(currentUser)) {
            modelAndView.addObject(ERROR_CODE, "403");
            return true;
        }
        return false;
    }

    private void enrichWithDataForAllManageableUsers(ModelAndView modelAndView, UserAdminViewDto currentUser) {
        modelAndView
                .addObject(LOWER_LEVEL_USERS, userService
                        .getUsersWithLowerRoleThan(currentUser.getRole()))
                .addObject(POSSIBLE_ROLES, userService
                        .getRolesLowerThan(currentUser.getRole()));
    }

    private void importUserForEdit(ModelAndView modelAndView, Long id) {
        UserAdminViewDto user = getUser(id);
        modelAndView.addObject(USER_TO_EDIT, user);
    }
}
