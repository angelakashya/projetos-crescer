package br.com.cwi.crescer.melevaai.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "carteira_nacional_habilitacao")
@SequenceGenerator(name = "seq_carteira_nacional_habilitacao", sequenceName = "seq_carteira_nacional_habilitacao", allocationSize = 1)
public class CarteiraNacionalHabilitacao {

    @Id
    @Column(name = "id_cnh")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carteira_nacional_habilitacao")
    private Integer idCnh;

    @Column(name = "numero")
    private String numero;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(name = "data_vencimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVencimento;


    @JsonIgnore
    public boolean isVencida() {
        return dataVencimento.isBefore(LocalDate.now());
    }
}
