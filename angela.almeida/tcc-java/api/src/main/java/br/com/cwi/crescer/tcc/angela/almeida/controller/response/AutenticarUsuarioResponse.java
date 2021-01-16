package br.com.cwi.crescer.tcc.angela.almeida.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutenticarUsuarioResponse {

    private String token;
    private Integer id;
    private String email;
    private String nomeCompleto;
    private String imagem;
    private String apelido;
}
