package br.com.cwi.crescer.melevaai.controller.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.cwi.crescer.melevaai.domain.CarteiraNacionalHabilitacao;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MotoristaRequest {

    private CarteiraNacionalHabilitacao cnh;

    private String nome;

    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String cpf;
}

