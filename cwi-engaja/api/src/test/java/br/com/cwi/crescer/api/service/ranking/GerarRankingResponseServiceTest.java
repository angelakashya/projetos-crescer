package br.com.cwi.crescer.api.service.ranking;

import br.com.cwi.crescer.api.controller.responsedto.RankingResponse;
import br.com.cwi.crescer.api.controller.responsedto.UsuarioRankingResponse;
import br.com.cwi.crescer.api.domain.Ranking;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class GerarRankingResponseServiceTest {

    @InjectMocks
    GerarRankingResponseService tested;

    @Mock
    BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Mock
    BuscarRankingGlobalService buscarGlobal;

    @Mock
    BuscarRankingEquipeService buscarEquipe;

    @Mock
    GerarUsuarioRankingResponseService gerarResponse;

    @Test
    public void deveGerarRankingResponseComSucesso() {
        Usuario usuario = new Usuario();
        usuario.setGestor("andrenunes");

        List<Ranking> ranking = new ArrayList<>();
        Ranking topRanking = new Ranking();
        ranking.add(topRanking);


        Mockito.when(buscarUsuarioAutenticadoService.buscar()).thenReturn(usuario);
        Mockito.when(buscarGlobal.buscar()).thenReturn(ranking);
        Mockito.when(buscarEquipe.buscar(usuario.getGestor())).thenReturn(ranking);
        Mockito.when(gerarResponse.gerar(topRanking)).thenReturn(new UsuarioRankingResponse());


        RankingResponse response = tested.gerar();

        Mockito.verify(buscarUsuarioAutenticadoService).buscar();
        Mockito.verify(buscarGlobal).buscar();
        Mockito.verify(buscarEquipe).buscar(usuario.getGestor());
        Mockito.verify(gerarResponse, Mockito.times(2)).gerar(topRanking);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getEquipe());
        Assert.assertNotNull(response.getGlobal());
    }
}