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

@RunWith(MockitoJUnitRunner.class)
public class BuscarUsuarioServiceTest {

    @InjectMocks
    BuscarUsuarioService tested;

    @Mock
    UsuarioRepository repository;


    @Test
    public void deveBuscarComSucesso() {
        String user = "joao.rocha";
        Usuario usuario = new Usuario();

        Mockito.when(repository.findByUser(user)).thenReturn(Optional.of(usuario));

        Usuario result = tested.buscar(user);

        Mockito.verify(repository).findByUser(user);

        Assert.assertNotNull(result);
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoNaoEncontrarUsuario() {
        String user = "joao.rocha";

        Mockito.when(repository.findByUser(user)).thenReturn(Optional.empty());

        try{
            tested.buscar(user);
        }catch(ResponseStatusException e){

            Mockito.verify(repository).findByUser(user);

            Assert.assertEquals("Houve um problema ao buscar informações do usuário.", e.getReason());

            throw e;
        }
    }
}