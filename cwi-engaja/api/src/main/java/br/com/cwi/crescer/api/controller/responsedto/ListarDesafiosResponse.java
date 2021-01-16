package br.com.cwi.crescer.api.controller.responsedto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListarDesafiosResponse {

    private Integer id;
    private String titulo;
    private Boolean jaContribuiu;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLimite;
    private int quantidadeParticipantes;
    private List<DesafioMetaResponse> metas;
    private Boolean isChegandoAoFim;
    private Boolean isEquipe;
    private Boolean isGlobal;
    private Boolean isAtivo;
    private Boolean curtiu;
    private Long quantidadeDeCurtidas;
    private Long quantidadeComentarios;

}
