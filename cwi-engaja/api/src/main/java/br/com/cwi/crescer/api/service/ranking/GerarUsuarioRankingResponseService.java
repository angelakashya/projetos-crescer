package br.com.cwi.crescer.api.service.ranking;

import br.com.cwi.crescer.api.controller.responsedto.UsuarioRankingResponse;
import br.com.cwi.crescer.api.domain.Ranking;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerarUsuarioRankingResponseService {

    @Autowired
    BuscarUsuarioPorIdService buscarUsuario;

    public UsuarioRankingResponse gerar(Ranking ranking){

        UsuarioRankingResponse response = new UsuarioRankingResponse();
        Usuario usuario = buscarUsuario.buscar(ranking.getIdUsuario());

        response.setNome(usuario.getNome());

        return response;
    }
}
