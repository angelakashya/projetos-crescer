package br.com.cwi.crescer.melevaai.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "motorista")
@NoArgsConstructor
public class Motorista extends Pessoa {

    @Transient
    private static final int IDADE_MINIMA_MOTORISTA = 18;

    public Motorista(String nomeCompleto, LocalDate dataNascimento, String email, String cpf, String ativo) {
        super(nomeCompleto, dataNascimento, email, cpf, ativo);
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cnh")
    private CarteiraNacionalHabilitacao cnh;

    @Column(name = "ocupado")
    private boolean ocupado;


    @JsonIgnore
    @Override
    protected int getIdadeMinima() {
        return IDADE_MINIMA_MOTORISTA;
    }

}
