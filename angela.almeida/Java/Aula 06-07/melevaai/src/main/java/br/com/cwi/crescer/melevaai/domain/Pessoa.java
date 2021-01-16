package br.com.cwi.crescer.melevaai.domain;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "cpf")
public abstract class Pessoa {

    @NotEmpty
    private String nome;

    @Email
    @NotEmpty
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull
    @Valid
    private CPF cpf;

    private ContaVirtual contaVirtual = new ContaVirtual(0.0);

    protected abstract int getIdadeMinima();

    public Pessoa(String nome, String email, LocalDate dataNascimento, CPF cpf) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    protected Pessoa() {

    }

    @JsonIgnore
    public int getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    public boolean idadeMinimaValida() {

        return this.getIdade() > getIdadeMinima();
    }

    public CPF getCpf() {
        return cpf;
    }
}

