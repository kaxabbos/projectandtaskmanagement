package com.projectandtaskmanagement.controller;

import com.projectandtaskmanagement.controller.main.Attributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stat")
public class StatCont extends Attributes {

    @GetMapping
    public String Stat(Model model) {
        AddAttributesStat(model);
        return "stat";
    }
}
