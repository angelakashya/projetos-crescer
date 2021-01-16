package br.com.cwi.crescer.api.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "usuario")
    private String user;

    @Column(name = "email")
    private String email;

    @Column(name = "usuario_gestor")
    private String gestor;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "tipo_cargo")
    private TipoCargo cargo;

    @Column(name = "cargo")
    private String posicao;

}
