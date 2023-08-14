package com.example.pp3312SpringBoot.controller;

import com.example.pp3312SpringBoot.entity.User;
import com.example.pp3312SpringBoot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    static final String REDIRECT_ROOT = "redirect:/";
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user-create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @GetMapping("/")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "listUser";
    }

    @PostMapping("/user-create")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "updateUser";
        }

        userService.add(user);
        return REDIRECT_ROOT;
    }

    @DeleteMapping("/user-delete/{id}")
    public String deleteUserFromTable(@PathVariable("id") Long id) {
        userService.deleteUserFromTable(id);
        return REDIRECT_ROOT;
    }

    @PatchMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "updateUser";
    }

    @PatchMapping("/user-update")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "updateUser";
        }

        userService.updateUser(user);
        return REDIRECT_ROOT;
    }

}