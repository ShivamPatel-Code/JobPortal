package com.projects.jobportal.controller;

import com.projects.jobportal.entity.Users;
import com.projects.jobportal.entity.UsersType;
import com.projects.jobportal.services.UsersService;
import com.projects.jobportal.services.UsersTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;

@Controller
public class UsersController {

    private final UsersTypeService usersTypeService;
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersTypeService usersTypeService, UsersService usersService) {
        this.usersTypeService = usersTypeService;
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        try {
            List<UsersType> usersTypes = usersTypeService.getAll();
            model.addAttribute("getAllTypes", usersTypes);
            model.addAttribute("user", new Users());
            return "register";
        } catch (Exception e) {
            LoggerFactory.getLogger(UsersController.class).error("Error occurred while fetching user types: {}", e.getMessage(), e);
            model.addAttribute("error", "Internal Server Error. Please try again later");
            return "error";
        }
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users, Model model) throws InterruptedException {
        Optional<Users> registeredUsers = usersService.getUserByEmail(users.getEmail());
        if (registeredUsers.isPresent()) {
            model.addAttribute("error", "Internal Server Error. Please try again later");
            return register(model);
        }
        try {
            usersService.addNew(users);
        } catch (Exception e){
            LoggerFactory.getLogger(UsersController.class).error("Error occurred while adding a new user: {}", e.getMessage(), e);
            model.addAttribute("error", "Internal Server Error. Please try again later");
            return "error";
        }

        return "redirect:/dashboard/";
    }
}
