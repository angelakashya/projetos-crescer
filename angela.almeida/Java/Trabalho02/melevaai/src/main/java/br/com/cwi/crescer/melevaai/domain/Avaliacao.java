package br.com.cwi.crescer.melevaai.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "avaliacao")
@SequenceGenerator(name = "seq_avaliacao", sequenceName = "seq_avaliacao", allocationSize = 1)
public class Avaliacao {

    @Id
    @Column(name = "id_avaliacao")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_avaliacao")
    private Integer idAvaliacao;

    @Column(name = "nota_passageiro")
    private Integer notaPassageiro;

    @Column(name = "nota_motorista")
    private Integer notaMotorista;
}
