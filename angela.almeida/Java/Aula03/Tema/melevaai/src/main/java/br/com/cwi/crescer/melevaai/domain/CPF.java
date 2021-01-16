package br.com.cwi.crescer.melevaai.domain;


import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(of="numero")
public class CPF {

    @NotEmpty
    private String numero;

    public CPF(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public CPF() {
    }
}

