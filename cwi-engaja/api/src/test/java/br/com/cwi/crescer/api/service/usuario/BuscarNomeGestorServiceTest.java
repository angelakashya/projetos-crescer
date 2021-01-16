package br.com.cwi.crescer.api.service.usuario;

import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.UsuarioRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BuscarNomeGestorServiceTest {

    @InjectMocks
    BuscarNomeGestorService tested;

    @Mock
    UsuarioRepository repository;

    Usuario usuario;

    @Before
    public void setup() {
        usuario = new Usuario();
    }

    @Test
    public void deveBuscarNomeDoGestorCorretamente() {
        usuario.setGestor("bellotti");
        Usuario gestor = new Usuario();
        gestor.setNome("Rafael Bellotti");

        Mockito.when(repository.findByUser(usuario.getGestor())).thenReturn(Optional.of(gestor));

        String nome = tested.buscar(usuario);

        Mockito.verify(repository).findByUser(usuario.getGestor());

        Assert.assertEquals(gestor.getNome(), nome);
    }

    @Test
    public void devePegarUsuarioDoGestorDoColaboradorCorretamente() {
        usuario.setGestor("bellotti");

        Mockito.when(repository.findByUser(usuario.getGestor())).thenReturn(Optional.empty());

        String nome = tested.buscar(usuario);

        Mockito.verify(repository).findByUser(usuario.getGestor());

        Assert.assertEquals(usuario.getGestor(), nome);
    }
}