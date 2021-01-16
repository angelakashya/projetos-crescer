package br.com.cwi.crescer.projeto2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HelloWorldController {
//
//    @GetMapping
//    public String sayHello() {
//        return "Hello World Web";
//    }

    @GetMapping
    public Pessoa getPessoa() {

        return new Pessoa("Angela", LocalDate.of(1997, 7, 03));
    }

}
