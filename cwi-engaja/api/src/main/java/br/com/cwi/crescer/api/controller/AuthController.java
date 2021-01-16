package br.com.cwi.crescer.api.controller;

import br.com.cwi.crescer.api.controller.requestdto.LoginRequest;
import br.com.cwi.crescer.api.controller.responsedto.LoginResponse;
import br.com.cwi.crescer.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    LoginService loginService;

    @PostMapping("public/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse fazerLogin(@RequestBody @Valid LoginRequest request) {
        return loginService.logar(request);
    }

}
