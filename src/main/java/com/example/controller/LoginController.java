package com.example.controller;

import com.example.service.CustomerService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

    private final CustomerService userService;

    public LoginController(CustomerService userService) {
        this.userService = userService;
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @GetMapping("/login")
    public ModelAndView getFormLogin() {
        return new ModelAndView("login");
    }
}
