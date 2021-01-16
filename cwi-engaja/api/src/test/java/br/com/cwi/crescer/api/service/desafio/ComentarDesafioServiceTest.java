package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.requestdto.DesafioComentarioRequest;
import br.com.cwi.crescer.api.controller.responsedto.DesafioComentarioResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioComentario;
import br.com.cwi.crescer.api.mapper.desafio.DesafioComentarioRequestMapper;
import br.com.cwi.crescer.api.service.usuario.VerificarUsuarioParticipanteService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComentarDesafioServiceTest {

    @InjectMocks
    ComentarDesafioService tested;

    @Mock
    BuscarDesafioPorIdService buscarDesafioPorIdService;

    @Mock
    VerificarUsuarioParticipanteService verificarUsuarioParticipanteService;

    @Mock
    DesafioComentarioRequestMapper requestMapper;

    @Mock
    SalvarComentarioDesafioService salvarComentarioDesafioService;

    @Test
    public void deveComentarDesafioComSucesso() {

        Desafio desafio = new Desafio();
        desafio.setId(1);

        DesafioComentario comentario = new DesafioComentario();
        comentario.setDesafio(desafio);

        DesafioComentarioRequest comentarioRequest = new DesafioComentarioRequest();
        comentarioRequest.setMensagem("Parabéns pela iniciativa!");

        DesafioComentarioResponse comentarioResponse = new DesafioComentarioResponse();
        comentarioResponse.setMensagem(comentarioRequest.getMensagem());

        Mockito.when(buscarDesafioPorIdService.buscar(desafio.getId()))
                .thenReturn(desafio);
        Mockito.when(requestMapper.apply(comentarioRequest))
                .thenReturn(comentario);
        Mockito.when(salvarComentarioDesafioService.salvar(comentario))
                .thenReturn(comentarioResponse);

        DesafioComentarioResponse result = tested.comentar(desafio.getId(), comentarioRequest);

        Mockito.verify(verificarUsuarioParticipanteService).verificar(desafio);
        Mockito.verify(salvarComentarioDesafioService).salvar(comentario);

        Assert.assertNotNull(result);
        Assert.assertEquals("Parabéns pela iniciativa!", result.getMensagem());

    }

}
