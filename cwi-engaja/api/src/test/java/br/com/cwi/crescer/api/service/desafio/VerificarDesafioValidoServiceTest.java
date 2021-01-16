package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Status;
import br.com.cwi.crescer.api.domain.TipoDesafio;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VerificarDesafioValidoServiceTest {

    @InjectMocks
    VerificarDesafioValidoService tested;

    @Test
    public void deveVerificarcomSucesso() {

        Desafio desafio = new Desafio();
        desafio.setStatus(Status.ATIVO);

        tested.isAtivo(desafio);

        Assert.assertNotNull(desafio);

    }

}
