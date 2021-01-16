package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import br.com.cwi.crescer.api.service.usuario.VerificarUsuarioParticipanteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AtualizarCurtidaServiceTest {

    @InjectMocks
    AtualizarCurtidaService tested;

    @Mock
    BuscarUsuarioAutenticadoService buscarUsuario;

    @Mock
    BuscarDesafioPorIdService buscarDesafio;

    @Mock
    VerificarUsuarioParticipanteService verificarParticipante;

    @Mock
    VerificarSeUsuarioJaCurtiuService verificarSeJaCurtiu;

    @Mock
    DescurtirDesafioService descurtirService;

    @Mock
    CurtirDesafioService curtirService;

    @Test
    public void deveAtualizarComSucesso() {

        Usuario usuario = new Usuario();

        Desafio desafio = new Desafio();
        desafio.setId(1);

        Mockito.when(buscarUsuario.buscar())
                .thenReturn(usuario);
        Mockito.when(buscarDesafio.buscar(desafio.getId()))
                .thenReturn(desafio);

        tested.atualizar(desafio.getId());

        Mockito.verify(verificarParticipante).verificar(desafio);
        Mockito.verify(verificarSeJaCurtiu).verificar(desafio, usuario);
        Mockito.verify(curtirService).curtir(desafio, usuario);

    }

}
