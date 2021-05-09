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

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user/addUser";
    }

    @PostMapping("/add")
    public @ResponseBody String addNewUser (@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "Saved";
    }
}