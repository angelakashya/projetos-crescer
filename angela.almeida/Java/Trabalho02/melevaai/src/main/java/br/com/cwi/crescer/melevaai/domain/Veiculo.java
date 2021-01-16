package br.com.cwi.crescer.melevaai.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "veiculo ")
@SequenceGenerator(name = "seq_veiculo", sequenceName = "seq_veiculo", allocationSize = 1)
public class Veiculo {

    @Id
    @Column(name = "id_veiculo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_veiculo")
    private Integer idVeiculo;

    @Column(name = "placa")
    private String placa;

    @Column(name = "marca")
    @Enumerated(EnumType.STRING)
    private Marca marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "cor")
    @Enumerated(EnumType.STRING)
    private Cor cor;

    @Column(name = "foto")
    private String foto;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(name = "quantidade_lugares")
    private Integer quantidadeLugares;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_motorista")
    private Motorista motorista;
}
