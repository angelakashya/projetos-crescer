package br.com.cwi.crescer.tcc.angela.almeida.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class UsuarioRequest {

    private String nomeCompleto;

    private String email;

    private String apelido;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String senha;

    private String imagemPerfil;
}
