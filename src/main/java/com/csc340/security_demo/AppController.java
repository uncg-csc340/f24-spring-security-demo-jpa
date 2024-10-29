package com.csc340.security_demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"", "/", "/home", "app"})
    public String home() {
        return "redirect:/articles/all";
    }


    @GetMapping("/error")
    public String showError() {
        return "error";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/403")
    public String _403() {
        return "403";
    }
}
