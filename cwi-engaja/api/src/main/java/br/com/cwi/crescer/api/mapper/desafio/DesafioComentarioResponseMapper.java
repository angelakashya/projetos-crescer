package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.controller.responsedto.DesafioComentarioResponse;
import br.com.cwi.crescer.api.domain.DesafioComentario;
import org.springframework.stereotype.Component;

@Component
public class DesafioComentarioResponseMapper {

    public DesafioComentarioResponse apply(DesafioComentario desafioComentario) {

        DesafioComentarioResponse response = new DesafioComentarioResponse();
        response.setDataCadastro(desafioComentario.getDataCadastro());
        response.setMensagem(desafioComentario.getMensagem());
        response.setUsuario(desafioComentario.getUsuario().getNome());

        return response;
    }
}
