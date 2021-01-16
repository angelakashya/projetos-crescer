package br.com.cwi.crescer.api.controller.responsedto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResultadoDesafioComOpcaoResponse extends ResultadoDesafioResponse{

    private String contribuicao;
}
