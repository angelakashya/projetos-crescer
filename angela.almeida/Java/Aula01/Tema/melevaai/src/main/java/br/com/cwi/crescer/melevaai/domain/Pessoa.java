package br.com.cwi.crescer.melevaai.domain;

import java.time.LocalDate;
import java.time.Period;

public abstract class Pessoa {
    private String nomeCompleto;
    private String email;
    private LocalDate dataDeNascimento;
    private CPF cpf;
    private CarteiraNacionalDeHabilitacao cnh;

    public Pessoa(String nomeCompleto, String email, LocalDate dataDeNascimento, CPF cpf) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }

    public int getIdade() {
        return Period.between(this.getDataDeNascimento(), LocalDate.now()).getYears();
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }


    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public CPF getCpf() {
        return cpf;
    }

}

