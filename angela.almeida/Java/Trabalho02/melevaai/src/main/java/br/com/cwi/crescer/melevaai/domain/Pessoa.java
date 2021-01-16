package br.com.cwi.crescer.melevaai.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@Entity
@Table(name = "pessoa")
@NoArgsConstructor
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

    public Pessoa(String nomeCompleto, LocalDate dataNascimento, String email, String cpf, String ativo) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.cpf = cpf;
        this.ativo = ativo;
    }


    @Id
    @Column(name = "id_pessoa")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    private Integer id;

    @Column(name="nome_completo")
    private String nomeCompleto;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "ativo")
    private String ativo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_conta")
    private ContaVirtual contaVirtual;

    protected abstract int getIdadeMinima();

    @JsonIgnore
    public int getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    public boolean idadeMinimaValida() {

        return this.getIdade() > getIdadeMinima();
    }

}
