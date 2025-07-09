package com.prototype.pryt3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {

    // Handles root ("/")
    @GetMapping("/")
    public String index() {
        return "forward:/index.html";
    }

    // Handles all other paths that do not contain a dot (.)
    @RequestMapping("/{path:^(?!api|assets|.*\\..*$).*$}")
    public String forward() {
        return "forward:/index.html";
    }
}