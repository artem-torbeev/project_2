package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/list/create")
public class CreateController {

    private final UserService userService;

    @Autowired
    public CreateController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String create() {
        return "create";
    }

    @PostMapping
    public String createUser(HttpServletRequest req) {
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        userService.creatUser(new User(name, lastname, email, password));
        return "redirect:/list";
    }
}
