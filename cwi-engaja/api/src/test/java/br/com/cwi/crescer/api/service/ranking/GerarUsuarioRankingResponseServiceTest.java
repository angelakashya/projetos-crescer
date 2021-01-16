package br.com.cwi.crescer.api.service.ranking;

import br.com.cwi.crescer.api.controller.responsedto.UsuarioRankingResponse;
import br.com.cwi.crescer.api.domain.Ranking;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioPorIdService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GerarUsuarioRankingResponseServiceTest {

    @InjectMocks
    GerarUsuarioRankingResponseService tested;

    @Mock
    BuscarUsuarioPorIdService buscarUsuarioPorId;
    @Test
    public void deveGerarUsuarioRankingResponseComSucesso() {

        Ranking ranking = new Ranking();
        ranking.setIdUsuario(1);
        Usuario usuario = new Usuario();
        usuario.setNome("Joao Pedro");

        Mockito.when(buscarUsuarioPorId.buscar(ranking.getIdUsuario())).thenReturn(usuario);

        UsuarioRankingResponse result = tested.gerar(ranking);

        Mockito.verify(buscarUsuarioPorId).buscar(ranking.getIdUsuario());

        Assert.assertNotNull(result);
        Assert.assertEquals(usuario.getNome(), result.getNome());
    }
}