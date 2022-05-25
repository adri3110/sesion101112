package com.example.sesion101112.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/saludo")
    public String HelloController(){
        return "Hola desde Hello Controller";
    }

}
