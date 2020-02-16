package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/list")
public class listController {

    private final UserService userService;

    @Autowired
    public listController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView list() {
        List<User> users = userService.selectAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list");
        modelAndView.addObject("listUser", users);
        return modelAndView;
    }
}
