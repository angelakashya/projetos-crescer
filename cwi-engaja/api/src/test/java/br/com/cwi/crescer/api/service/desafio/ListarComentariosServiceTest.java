package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.responsedto.DesafioComentarioResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioComentario;
import br.com.cwi.crescer.api.mapper.desafio.DesafioComentarioResponseMapper;
import br.com.cwi.crescer.api.repository.DesafioComentarioRepository;
import br.com.cwi.crescer.api.service.usuario.VerificarUsuarioParticipanteService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ListarComentariosServiceTest {

    @InjectMocks
    ListarComentariosService tested;

    @Mock
    BuscarDesafioPorIdService buscarDesafioPorIdService;

    @Mock
    DesafioComentarioRepository desafioComentarioRepository;

    @Mock
    VerificarUsuarioParticipanteService verificarUsuarioParticipanteService;

    @Mock
    DesafioComentarioResponseMapper desafioComentarioResponseMapper;

    @Test
    public void deveListarComentariosComSucesso() {

        Desafio desafio = new Desafio();
        desafio.setId(1);

        DesafioComentario comentario = new DesafioComentario();
        comentario.setDesafio(desafio);
        comentario.setMensagem("Muito bom, vou participar!");

        List<DesafioComentario> comentarios = new ArrayList<>();
        comentarios.add(comentario);

        DesafioComentarioResponse comentarioResponse = new DesafioComentarioResponse();
        comentarioResponse.setMensagem(comentario.getMensagem());
        comentario.setDesafio(desafio);

        List<DesafioComentarioResponse> comentariosResponse = new ArrayList<>();
        comentariosResponse.add(comentarioResponse);

        Mockito.when(buscarDesafioPorIdService.buscar(desafio.getId()))
                .thenReturn(desafio);
        Mockito.when(desafioComentarioRepository.findByDesafio(desafio))
                .thenReturn(Optional.of(comentarios));
        Mockito.when(desafioComentarioResponseMapper.apply(comentario))
                .thenReturn(comentarioResponse);

        List<DesafioComentarioResponse> result = tested.listar(desafio.getId());

        Mockito.verify(buscarDesafioPorIdService).buscar(1);
        Mockito.verify(verificarUsuarioParticipanteService).verificar(desafio);

        Assert.assertNotNull(comentariosResponse);

    }
}
