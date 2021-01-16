package br.com.cwi.crescer.projeto1.domain;

import br.com.cwi.crescer.projeto1.exception.IdadeMininaInvalidaException;

import java.time.LocalDate;

public class Passageiro extends Pessoa {

    private static final int IDADE_MINIMA = 16;

    public Passageiro(String nomeCompleto, String email, LocalDate dataDeNascimento, CPF cpf) {
        super(nomeCompleto, email, dataDeNascimento, cpf);

        validarIdade();
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
