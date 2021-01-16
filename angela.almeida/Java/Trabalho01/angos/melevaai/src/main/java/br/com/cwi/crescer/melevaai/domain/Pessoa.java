package br.com.cwi.crescer.melevaai.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Getter
@Setter
public abstract class Pessoa {

    @NotEmpty(message="O nome é obrigatório")
    private String nomeCompleto;

    @Email(message = "Esse email não esta no formato correto")
    @NotEmpty(message = "O email é obrigatório no cadastro")
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;

    @NotNull
    @Valid
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return cpf.equals(pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}