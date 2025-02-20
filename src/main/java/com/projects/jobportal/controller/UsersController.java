package com.projects.jobportal.controller;

import com.projects.jobportal.entity.Users;
import com.projects.jobportal.entity.UsersType;
import com.projects.jobportal.services.UsersTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsersController {

    private final UsersTypeService usersTypeService;

    @Autowired
    public UsersController(UsersTypeService usersTypeService) {
        this.usersTypeService = usersTypeService;
    }

    @GetMapping("/register")
    public String register(Model model){
        List<UsersType> usersTypes =  usersTypeService.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("users", new Users());
        return "register";


    }
}
