package br.com.cwi.crescer.api.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "desafio_usuario_contribuicao")
@SequenceGenerator(name = "seq_desafio_usuario_contribuicao", sequenceName = "seq_desafio_usuario_contribuicao", allocationSize = 1)
public class DesafioUsuarioContribuicao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_desafio_usuario_contribuicao")
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_desafio")
    private Desafio desafio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_desafio_opcao_contribuicao")
    private DesafioOpcaoContribuicao desafioOpcaoContribuicao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
