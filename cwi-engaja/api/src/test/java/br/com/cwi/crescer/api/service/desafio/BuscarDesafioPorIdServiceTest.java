package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.repository.DesafioRepository;
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
public class BuscarDesafioPorIdServiceTest {

    @InjectMocks
    BuscarDesafioPorIdService tested;

    @Mock
    DesafioRepository repository;


    @Test
    public void deveBuscarComSucesso() {
        Integer idDesafio = 1;
        Desafio desafio = new Desafio();

        Mockito.when(repository.findById(idDesafio)).thenReturn(Optional.of(desafio));

        Desafio result = tested.buscar(idDesafio);

        Mockito.verify(repository).findById(idDesafio);

        Assert.assertNotNull(result);
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoNaoEncontrarDesafio() {
        Integer idDesafio = 1;

        Mockito.when(repository.findById(idDesafio)).thenReturn(Optional.empty());

        try{
            tested.buscar(idDesafio);
        }catch(ResponseStatusException e){

            Mockito.verify(repository).findById(idDesafio);
            Assert.assertEquals("Desafio não encontrado.", e.getReason());
            throw e;
        }



    }
}