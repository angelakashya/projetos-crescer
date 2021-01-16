package br.com.cwi.crescer.melevaai.domain;


import br.com.cwi.crescer.melevaai.exceptions.IdadeMininaInvalidaException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
public class Motorista extends Pessoa {

    public static final int IDADE_MINIMA = 18;
    private CarteiraNacionalDeHabilitacao cnh;

    public Motorista(String nomeCompleto, String email, LocalDate dataDeNascimento, CPF cpf, CarteiraNacionalDeHabilitacao cnh) {
        super(nomeCompleto, email, dataDeNascimento, cpf);
        this.cnh = cnh;

        validarIdade();
    }

    public CarteiraNacionalDeHabilitacao getCnh() {
        return cnh;
    }

    private boolean isIdadeValida() {
        return super.getIdade() >= IDADE_MINIMA;
    }

    public void validarIdade() {
        if (!this.isIdadeValida()) {
            throw new IdadeMininaInvalidaException();
        }
    }
}

