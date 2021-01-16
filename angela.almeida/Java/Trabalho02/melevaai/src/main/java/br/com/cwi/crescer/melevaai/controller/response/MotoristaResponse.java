package br.com.cwi.crescer.melevaai.controller.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.cwi.crescer.melevaai.domain.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MotoristaResponse {

    private String nome;

    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String numeroCpf;

    private String numeroCnh;

    private Categoria categoriaCnh;

    @JsonIgnore
    private boolean ocupado;


}

