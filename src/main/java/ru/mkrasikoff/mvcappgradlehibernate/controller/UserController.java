package ru.mkrasikoff.mvcappgradlehibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mkrasikoff.mvcappgradlehibernate.dao.UserRepository;
import ru.mkrasikoff.mvcappgradlehibernate.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/show")
    public String showAll(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/showAll";
    }

    @GetMapping("/show/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userRepository.findById(id).get());
        return "user/showUser";
    }

    @GetMapping("/add")
    public String addUserPage(Model model) {
        model.addAttribute("user", new User());
        return "user/addUser";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "/welcomePage";
    }

    @GetMapping("/delete")
    public String deleteUserPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/deleteUser";
    }

    @DeleteMapping("/delete")
    public @ResponseBody String deleteUser(@ModelAttribute("user") User user) {
        userRepository.delete(user);
        return "Deleted";
    }
}