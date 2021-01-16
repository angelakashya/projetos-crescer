package br.com.cwi.crescer.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "desafio_opcao_contribuicao")
@SequenceGenerator(name = "seq_desafio_opcao_contribuicao", sequenceName = "seq_desafio_opcao_contribuicao", allocationSize = 1)
public class DesafioOpcaoContribuicao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_desafio_opcao_contribuicao")
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_desafio")
    private Desafio desafio;

    @Column(name = "contribuicao")
    private String contribuicao;

}
