package ru.mkrasikoff.mvcappgradlehibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mkrasikoff.mvcappgradlehibernate.dao.UserDAO;
import ru.mkrasikoff.mvcappgradlehibernate.dao.UserRepository;
import ru.mkrasikoff.mvcappgradlehibernate.model.User;

import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    ArrayList arrayList;
    @GetMapping("/show")
    public String showAll(Model model) {
        model.addAttribute("users", userDAO.findAllUsers());
        return "user/showAll";
    }

    @GetMapping("/show/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.findUserById(id));
        return "user/showUser";
    }

    @GetMapping("/add")
    public String addUserPage(Model model) {
        model.addAttribute("user", new User());
        return "user/addUser";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userDAO.save(user);
        return "redirect:/user/show";
    }

    @PostMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        userDAO.delete(id);
        return "redirect:/user/show";
    }
}