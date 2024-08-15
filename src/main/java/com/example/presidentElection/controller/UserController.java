package com.example.presidentElection.controller;

import com.example.presidentElection.dto.UserDto;
import com.example.presidentElection.entity.User;
import com.example.presidentElection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public String userProfile(@PathVariable(value = "id") long id, Model model) {
        User user = userService.findUserById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "userProfile";
        } else {
            return "userNotFound";
        }
    }

    @GetMapping("/user/{id}/saveDescription")
    public String addDescription(@PathVariable(value = "id") long id,@ModelAttribute("user") UserDto userDto, Model model) {
        User existingUser = userService.findUserById(id);
        return "addUserDescription";
    }

    @PostMapping("/user/{id}/saveDescription")
    public String saveDescription(@PathVariable(value = "id") long id,@ModelAttribute("user") UserDto userDto,@RequestParam String description, Model model) {
        User existingUser = userService.findUserById(id);
        if (existingUser != null) {
            userDto.setDescription(description);
            userService.saveUser(userDto);
            return "redirect:/users";
        } else {
            return "userNotFound";
        }
    }
}
