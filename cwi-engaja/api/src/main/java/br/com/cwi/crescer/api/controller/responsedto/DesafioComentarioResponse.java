package br.com.cwi.crescer.api.controller.responsedto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DesafioComentarioResponse {

    private String usuario;
    private String mensagem;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

}
