package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/list/edit/{id}")
public class EditController {

    private final UserService userService;

    @Autowired
    public EditController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView edit(@PathVariable Long id) {
        User user = userService.selectUserId(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping
    public String editUser(@PathVariable Long id, HttpServletRequest req) {
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        userService.updateUser(id, name, lastname, email);
        return "redirect:/list";
    }
}
