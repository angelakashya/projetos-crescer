package br.com.cwi.crescer.api.service.ranking;

import br.com.cwi.crescer.api.controller.responsedto.RankingResponse;
import br.com.cwi.crescer.api.controller.responsedto.UsuarioRankingResponse;
import br.com.cwi.crescer.api.domain.Ranking;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GerarRankingResponseService {

    @Autowired
    BuscarRankingGlobalService buscarGlobal;

    @Autowired
    BuscarRankingEquipeService buscarEquipe;

    @Autowired
    BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    GerarUsuarioRankingResponseService gerarResponse;

    public RankingResponse gerar() {

        Usuario usuario = buscarUsuarioAutenticadoService.buscar();

        List<Ranking> global = buscarGlobal.buscar();

        List<Ranking> equipe = buscarEquipe.buscar(usuario.getGestor());

        List<UsuarioRankingResponse> equipeResponse = equipe
                .stream()
                .map(r -> gerarResponse.gerar(r))
                .collect(Collectors.toList());

        List<UsuarioRankingResponse> globalResponse = global
                .stream()
                .map(r -> gerarResponse.gerar(r))
                .collect(Collectors.toList());


        RankingResponse response = new RankingResponse();

        response.setGlobal(globalResponse);
        response.setEquipe(equipeResponse);

        return response;
    }
}
