package com.exampleui.demoui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootPage {

    @RequestMapping
    public String goToWelcomePage(){
        return "redirect:/eshop";
    }


}
