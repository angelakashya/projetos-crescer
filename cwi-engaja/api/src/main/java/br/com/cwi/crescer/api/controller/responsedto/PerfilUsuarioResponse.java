package br.com.cwi.crescer.api.controller.responsedto;

import lombok.Data;

@Data
public class PerfilUsuarioResponse {

    private String nome;

    private String nomeGestor;

    private Boolean isGlobal;

    private Boolean isGestor;

    private String posicao;

}
