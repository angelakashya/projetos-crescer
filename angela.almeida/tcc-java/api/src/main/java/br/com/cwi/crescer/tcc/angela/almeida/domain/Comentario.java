package br.com.cwi.crescer.tcc.angela.almeida.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comentario")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "comentario_id_seq", sequenceName = "comentario_id_seq", allocationSize = 1)
public class Comentario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comentario_id_seq" )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_postagem")
    private Postagem idPostagem;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    @Column(name = "texto")
    private String texto;

    @Column(name = "imagem")
    private String imagem;

}
