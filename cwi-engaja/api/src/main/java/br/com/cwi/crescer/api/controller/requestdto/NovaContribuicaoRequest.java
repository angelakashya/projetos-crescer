package br.com.cwi.crescer.api.controller.requestdto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class NovaContribuicaoRequest {

    @NotNull
    private Integer idDesafio;

    @NotEmpty
    private String contribuicao;
}
