package br.com.cwi.crescer.tcc.angela.almeida.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "postagem")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
@SequenceGenerator(name = "postagem_id_seq", sequenceName = "postagem_id_seq", allocationSize = 1)
public class Postagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postagem_id_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    @Column(name = "texto")
    private String texto;

    @Column(name = "imagem")
    private String imagem;

    @JsonIgnore
    @OneToMany(mappedBy = "idPostagem")
    private Collection<Comentario> comentarioCollection;

    @JsonIgnore
    @OneToMany(mappedBy = "idPostagem")
    private Collection<Curtida> curtidaCollection;
}
