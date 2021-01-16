package br.com.cwi.crescer.melevaai.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, of = {})
@ToString(callSuper = true)
public class Motorista extends Pessoa {

    public static final int IDADE_MINIMA = 18;

    private CarteiraNacionalHabilitacao cnh;

    private boolean ocupado;

    public Motorista(String nomeCompleto, String email, LocalDate dataNascimento, CPF cpf, CarteiraNacionalHabilitacao cnh) {
        super(nomeCompleto, email, dataNascimento, cpf);
        this.cnh = cnh;
    }

    public Motorista() {

    }

    @JsonIgnore
    @Override
    protected int getIdadeMinima() {
        return IDADE_MINIMA;
    }

}

