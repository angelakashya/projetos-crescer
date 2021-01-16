package br.com.cwi.crescer.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "desafio")
@NoArgsConstructor
@SequenceGenerator(name = "seq_desafio", sequenceName = "seq_desafio", allocationSize = 1)
public class Desafio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_desafio")
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "data_limite")
    private LocalDateTime dataLimite;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", insertable = false)
    private Status status;

    @Column(name = "quantidade_participantes")
    private int quantidadeParticipantes;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_desafio")
    private TipoDesafio tipoDesafio;

    @Transient
    private List<DesafioMeta> meta;

    @Transient
    private List<DesafioOpcaoContribuicao> opcaoContribuicao;

}
