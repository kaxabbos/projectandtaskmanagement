package com.projectandtaskmanagement.controller;

import com.projectandtaskmanagement.controller.main.Attributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginCont extends Attributes {

    @GetMapping
    public String login() {
        return "login";
    }
}
