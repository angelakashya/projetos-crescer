package br.com.cwi.crescer.api.controller.responsedto;

import br.com.cwi.crescer.api.domain.DesafioMeta;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.domain.Status;
import br.com.cwi.crescer.api.domain.TipoDesafio;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class DesafioResponse {

    private Integer id;
    private String titulo;
    private String descricao;
    private List<DesafioMeta> meta;
    private List<DesafioOpcaoContribuicao> opcaoContribuicao;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataLimite;
    private TipoDesafio tipoDesafio;
    private Status status;

}
