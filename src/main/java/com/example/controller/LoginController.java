package com.example.controller;

import com.example.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {

    private final CustomerService userService;

    public LoginController(CustomerService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView getFormLogin() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView loginUser(HttpServletRequest request) {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        ModelAndView modelAndView = new ModelAndView();
        if (userService.getUserByPassword(password) != null) {
            modelAndView.setViewName("user");
            modelAndView.addObject("name", name);
            return modelAndView;
        } else {
            return new ModelAndView("error");
        }
    }
}
