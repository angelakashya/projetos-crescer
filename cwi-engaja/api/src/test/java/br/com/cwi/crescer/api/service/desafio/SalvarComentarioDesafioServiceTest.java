package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.responsedto.DesafioComentarioResponse;
import br.com.cwi.crescer.api.domain.DesafioComentario;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.mapper.desafio.DesafioComentarioResponseMapper;
import br.com.cwi.crescer.api.repository.DesafioComentarioRepository;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SalvarComentarioDesafioServiceTest {

    @InjectMocks
    SalvarComentarioDesafioService tested;

    @Mock
    BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Mock
    DesafioComentarioRepository desafioComentarioRepository;

    @Mock
    DesafioComentarioResponseMapper desafioComentarioResponseMapper;

    @Test
    public void deveSalvarComSucesso() {

        Usuario usuario = new Usuario();
        DesafioComentario comentario = new DesafioComentario();
        comentario.setUsuario(usuario);
        comentario.setMensagem("Quando será o curso?");
        DesafioComentarioResponse comentarioResponse = new DesafioComentarioResponse();
        comentarioResponse.setUsuario(usuario.getNome());
        comentario.setMensagem(comentario.getMensagem());

        Mockito.when(desafioComentarioResponseMapper.apply(comentario))
                .thenReturn(comentarioResponse);

        tested.salvar(comentario);

        Mockito.verify(desafioComentarioRepository).save(comentario);

        Assert.assertNotNull(comentario);

    }

}
