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

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarEquipeDoUsuarioServiceTest {

    @InjectMocks
    BuscarEquipeDoUsuarioService tested;

    @Mock
    UsuarioRepository repository;

    @Test
    public void deveBuscar() {
        Usuario usuario = new Usuario();
        usuario.setUser("joao.rocha");
        List<Usuario> retorno = new ArrayList<>();

        Mockito.when(repository.findByGestor(usuario.getUser())).thenReturn(retorno);

        List<Usuario> result = tested.buscar(usuario);

        Mockito.verify(repository).findByGestor(usuario.getUser());
        Assert.assertNotNull(result);
    }
}