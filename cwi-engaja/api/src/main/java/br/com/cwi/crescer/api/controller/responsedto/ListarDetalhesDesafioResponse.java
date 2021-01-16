package br.com.cwi.crescer.api.controller.responsedto;

import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListarDetalhesDesafioResponse {

    private Integer id;
    private String titulo;
    private String descricao;
    private Boolean jaContribuiu;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLimite;
    private int quantidadeParticipantes;
    private Long maxParticipantes;
    private List<DesafioMetaResponse> metas;
    private List<DesafioOpcaoContribuicao> opcaoContribuicao;
    private Boolean isCriador;
    private Boolean isAtivo;
    private Boolean isEquipe;
    private Boolean curtiu;
    private Long quantidadeDeCurtidas;
    private Long quantidadeComentarios;

}
