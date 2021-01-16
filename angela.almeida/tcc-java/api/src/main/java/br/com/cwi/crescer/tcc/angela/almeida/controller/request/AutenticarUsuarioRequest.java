package br.com.cwi.crescer.tcc.angela.almeida.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutenticarUsuarioRequest {

    private String email;
    private String password;

}
