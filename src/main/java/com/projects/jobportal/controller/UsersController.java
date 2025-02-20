package com.projects.jobportal.controller;

import com.projects.jobportal.entity.Users;
import com.projects.jobportal.entity.UsersType;
import com.projects.jobportal.services.UsersTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import org.slf4j.LoggerFactory;

@Controller
public class UsersController {

    private final UsersTypeService usersTypeService;

    @Autowired
    public UsersController(UsersTypeService usersTypeService) {
        this.usersTypeService = usersTypeService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        try {
            List<UsersType> usersTypes = usersTypeService.getAll();
            model.addAttribute("getAllTypes", usersTypes);
            model.addAttribute("user", new Users());
            return "register";
        } catch (Exception e) {
            // Log the exception using a logger instead of printing the stack trace
            LoggerFactory.getLogger(UsersController.class).error("Error occurred while fetching user types: {}", e.getMessage(), e);
            return "error";
        }
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users){
        System.out.println("user:: " + users);
        return "dashboard";
    }
}
