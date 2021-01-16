package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.controller.responsedto.ResultadoDesafioComOpcaoResponse;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import org.springframework.stereotype.Component;

@Component
public class ResultadoDesafioComOpcaoResponseMapper {

    public ResultadoDesafioComOpcaoResponse apply(DesafioUsuarioContribuicao contribuicao) {
        ResultadoDesafioComOpcaoResponse result = new ResultadoDesafioComOpcaoResponse();
        result.setNome(contribuicao.getUsuario().getNome());
        result.setContribuicao(contribuicao.getDesafioOpcaoContribuicao().getContribuicao());
        return result;
    }
}
