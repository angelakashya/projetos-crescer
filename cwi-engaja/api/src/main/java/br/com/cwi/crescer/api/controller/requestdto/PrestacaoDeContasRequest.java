package br.com.cwi.crescer.api.controller.requestdto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PrestacaoDeContasRequest {

    @NotNull
    private Integer idMeta;

    private String foto;

    private String descricao;
}
