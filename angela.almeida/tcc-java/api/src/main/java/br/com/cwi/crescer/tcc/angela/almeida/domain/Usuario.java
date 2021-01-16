package br.com.cwi.crescer.tcc.angela.almeida.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "usuario_id_seq", sequenceName = "usuario_id_seq", allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
    private Integer id;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "email")
    private String email;

    @Column(name = "apelido")
    private String apelido;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "senha")
    private String senha;

    @Column(name = "imagem_perfil")
    private String imagemPerfil;

    @JsonIgnore
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Amigo> amigosCollection;

    @JsonIgnore
    @OneToMany(mappedBy = "idAmigo")
    private Collection<Amigo> amigosCollection1;

    @JsonIgnore
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Postagem> postCollection;

    @JsonIgnore
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Comentario> comentarioCollection;

    @JsonIgnore
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Curtida> curtidaCollection;
}
