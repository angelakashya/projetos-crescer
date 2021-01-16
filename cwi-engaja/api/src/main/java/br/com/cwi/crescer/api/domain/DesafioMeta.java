package br.com.cwi.crescer.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "desafio_meta")
@SequenceGenerator(name = "seq_desafio_meta", sequenceName = "seq_desafio_meta", allocationSize = 1)
public class DesafioMeta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_desafio_meta")
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_desafio")
    private Desafio desafio;

    @Column(name = "quant_colaboradores")
    private int quantidadeColaboradores;

    @Column(name = "recompensa")
    private String recompensa;

    @Column(name = "descricao")
    private String descricaoPrestacao;

    @Column(name = "imagem")
    private String imagemPrestacao;

}
