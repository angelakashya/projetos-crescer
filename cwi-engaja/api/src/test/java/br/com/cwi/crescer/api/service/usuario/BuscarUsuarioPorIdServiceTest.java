package br.com.cwi.crescer.api.service.usuario;

import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.UsuarioRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BuscarUsuarioPorIdServiceTest {

    @InjectMocks
    BuscarUsuarioPorIdService tested;

    @Mock
    UsuarioRepository repository;

    @Test
    public void deveBuscarUsuarioComSucesso() {
        Integer id = 1;
        Usuario usuario = new Usuario();

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(usuario));

        Usuario result = tested.buscar(id);

        Mockito.verify(repository).findById(id);

        Assert.assertNotNull(result);
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoNaoAcharUsuario() {

        Integer id = 1;

        Mockito.when(repository.findById(id)).thenReturn(Optional.empty());

        try {
            tested.buscar(id);
        }catch(ResponseStatusException e) {
            Mockito.verify(repository).findById(id);
            Assert.assertEquals("Problemas ao buscar dados de usuário no banco.", e.getReason());

            throw e;
        }
    }
}