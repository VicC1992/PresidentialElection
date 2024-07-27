package com.example.presidentElection.controller;

import com.example.presidentElection.entity.User;
import com.example.presidentElection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public String userProfile(@PathVariable("id") long id, Model model) {
        User user = userService.findUserById(id);
            model.addAttribute("user", user);
            return "userProfile";
    }
}
