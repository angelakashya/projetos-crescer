package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.controller.responsedto.ResultadoDesafioResponse;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import org.springframework.stereotype.Component;

@Component
public class ResultadoDesafioSemOpcaoMapper {

    public ResultadoDesafioResponse apply(DesafioUsuarioContribuicao contribuicao){
        ResultadoDesafioResponse response = new ResultadoDesafioResponse();
        response.setNome(contribuicao.getUsuario().getNome());
        return response;
    }
}
