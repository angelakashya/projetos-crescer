package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Curtida;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.CurtidaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class DescurtirDesafioServiceTest {

    @InjectMocks
    DescurtirDesafioService tested;

    @Mock
    CurtidaRepository repository;

    @Test
    public void deveDescurtirComSucesso() {

        Curtida curtida = new Curtida();
        Desafio desafio = new Desafio();
        Usuario usuario = new Usuario();

        Mockito.when(repository.findByDesafioAndUsuario(desafio, usuario))
                .thenReturn(Optional.of(curtida));

        tested.descurtir(desafio, usuario);

        Mockito.verify(repository).delete(curtida);

    }
}
