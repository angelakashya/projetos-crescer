package br.com.cwi.crescer.api.controller.requestdto;

import br.com.cwi.crescer.api.domain.DesafioMeta;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.domain.TipoDesafio;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class DesafioRequest {

    @NotEmpty(message = "É necessário informar o título do desafio.")
    private String titulo;

    @NotEmpty(message = "É necessário informar a descrição do desafio.")
    private String descricao;

    private List<DesafioMeta> metas;

    private List<DesafioOpcaoContribuicao> desafioOpcaoContribuicao;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataLimite;

    @NotNull(message = "É necessário informar o tipo de desafio (GLOBAL ou EQUIPE).")
    private TipoDesafio tipoDesafio;

}