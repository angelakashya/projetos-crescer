package br.com.cwi.crescer.melevaai.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "corrida")
@SequenceGenerator(name = "seq_corrida", sequenceName = "seq_corrida", allocationSize = 1)
public class Corrida {

    @Id
    @Column(name = "id_corrida")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_corrida")
    private Integer idCorrida;

    @Column(name = "origem")
    private Integer origem;

    @Column(name = "destino")
    private Integer destino;

    @Column(name = "custo", columnDefinition = "NUMBER(38,2)")
    private Double custo;

    @Column(name = "data_hora_inicio")
    private LocalDateTime dataHoraInicio;

    @Column(name = "data_hora_fim")
    private LocalDateTime dataHoraFim;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_passageiro")
    private Passageiro passageiro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_avalicao")
    private Avaliacao avaliacao;
}
