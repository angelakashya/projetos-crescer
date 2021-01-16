package br.com.cwi.crescer.melevaai.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String sayHello() {
        return "Olá Crescer 2020/2";
    }
}
