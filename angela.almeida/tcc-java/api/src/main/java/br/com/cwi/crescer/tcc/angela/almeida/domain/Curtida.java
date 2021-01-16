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
@Table(name = "curtida")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "curtida_id_seq", sequenceName = "curtida_id_seq", allocationSize = 1)
public class Curtida {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curtida_id_seq" )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_postagem")
    private Postagem idPostagem;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

}
