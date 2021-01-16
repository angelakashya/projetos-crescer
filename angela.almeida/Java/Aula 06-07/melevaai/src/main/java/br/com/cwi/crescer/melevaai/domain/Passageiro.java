package br.com.cwi.crescer.melevaai.domain;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, of = {})
@ToString(callSuper = true)
public class Passageiro extends Pessoa {

    public static final int IDADE_MINIMA = 16;

    private boolean ocupado;

    public Passageiro(String nome, String email, LocalDate dataNascimento, CPF cpf) {
        super(nome, email, dataNascimento, cpf);
    }

    public Passageiro() {

    }

    @Override
    protected int getIdadeMinima() {
        return IDADE_MINIMA;
    }
}

