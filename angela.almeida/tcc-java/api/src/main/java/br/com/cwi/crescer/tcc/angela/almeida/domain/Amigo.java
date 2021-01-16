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
@Table(name = "amigo")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "amigo_id_seq", sequenceName = "amigo_id_seq", allocationSize = 1)
public class Amigo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amigo_id_seq" )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_amigo")
    private Usuario idAmigo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    @Column(name = "aceito")
    private boolean aceito;
}
