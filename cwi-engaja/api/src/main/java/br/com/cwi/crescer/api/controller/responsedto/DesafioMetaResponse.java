package br.com.cwi.crescer.api.controller.responsedto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DesafioMetaResponse {

    private Integer id;
    private String recompensa;
    private int quantidadeColaboradores;
    private Boolean prestacaoFeita;

}
