package br.com.cwi.crescer.melevaai.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "conta_virtual")
@SequenceGenerator(name = "seq_conta", sequenceName = "seq_conta", allocationSize = 1)
public class ContaVirtual {

    @Id
    @Column(name = "id_conta")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta")
    private Integer idConta;

//    @Column(name = "id_pessoa")
//    private Pessoa pessoa;

    @Column(name = "saldo", columnDefinition = "NUMBER(38,2)")
    private Double saldo;
}
