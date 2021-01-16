package br.com.cwi.crescer.api.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Ranking {

    @Id
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "usuario_gestor")
    private String gestor;

}
