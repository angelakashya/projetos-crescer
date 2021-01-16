package br.com.cwi.crescer.api.controller;

import br.com.cwi.crescer.api.controller.responsedto.PerfilUsuarioResponse;
import br.com.cwi.crescer.api.service.PerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("private")
public class PerfilController {

    @Autowired
    PerfilUsuarioService perfilService;


    @GetMapping("me")
    @ResponseStatus(HttpStatus.OK)
    public PerfilUsuarioResponse buscar() {
        return perfilService.buscar();
    }

}
