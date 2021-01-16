package br.com.cwi.crescer.api.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "desafio_comentario")
@SequenceGenerator(name = "seq_desafio_comentario", sequenceName = "seq_desafio_comentario", allocationSize = 1)
public class DesafioComentario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_desafio_comentario")
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_desafio")
    private Desafio desafio;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "mensagem")
    private String mensagem;

    @Column(name = "data_cadastro", insertable = false)
    private LocalDate dataCadastro;
    
}
