package br.senai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/pos-login/home")
    public String home() {
        return "pos-login/home";
    }
}
