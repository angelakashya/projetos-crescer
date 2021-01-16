package br.com.cwi.crescer.api.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "curtida")
public class Curtida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "id_desafio")
    @ManyToOne
    private Desafio desafio;

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;

}
