package br.com.cwi.crescer.melevaai.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "passageiro")
@NoArgsConstructor
public class Passageiro extends Pessoa {

    public static final int IDADE_MINIMA_PASSAGEIRO = 16;

    public Passageiro(String nomeCompleto, LocalDate dataNascimento, String email, String cpf, String ativo) {
        super(nomeCompleto, dataNascimento, email, cpf, ativo);
    }


    @JsonIgnore
    @Override
    protected int getIdadeMinima() {
        return IDADE_MINIMA_PASSAGEIRO;
    }

}
