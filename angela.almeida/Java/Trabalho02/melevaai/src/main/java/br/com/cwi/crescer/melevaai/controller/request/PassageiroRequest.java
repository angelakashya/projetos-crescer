package br.com.cwi.crescer.melevaai.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Getter
@Setter
public class PassageiroRequest {

    @NotEmpty(message = "O nome é obrigatório")
    private String nome;

    @Email(message = "Esse email não esta no formato correto")
    @NotEmpty(message = "O email é obrigatório")
    private String email;


    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotEmpty(message = "Data de Nascimento obrigatória")
    private LocalDate dataNascimento;

    private double saldo;


    private String cpf;
}

