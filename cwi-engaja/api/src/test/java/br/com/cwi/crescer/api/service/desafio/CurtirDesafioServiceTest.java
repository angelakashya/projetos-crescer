package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Curtida;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.mapper.desafio.NovaCurtidaMapper;
import br.com.cwi.crescer.api.repository.CurtidaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CurtirDesafioServiceTest {

    @InjectMocks
    CurtirDesafioService tested;

    @Mock
    NovaCurtidaMapper novaCurtidaMapper;

    @Mock
    CurtidaRepository repository;

    @Test
    public void deveCurtirComSucesso() {

        Desafio desafio = new Desafio();
        Usuario usuario = new Usuario();
        Curtida curtida = new Curtida();

        Mockito.when(novaCurtidaMapper.apply(curtida, usuario, desafio))
                .thenReturn(curtida);

        tested.curtir(desafio, usuario);

        Mockito.verify(repository).save(curtida);

    }
}
