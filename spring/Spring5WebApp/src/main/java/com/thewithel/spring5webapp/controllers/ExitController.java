package com.thewithel.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExitController {

    @RequestMapping("/exit")
    public void exit(){
        System.exit(0);
    }
}
