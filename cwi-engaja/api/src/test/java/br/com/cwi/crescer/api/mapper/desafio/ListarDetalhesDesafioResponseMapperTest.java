package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.controller.responsedto.ListarDetalhesDesafioResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

@RunWith(MockitoJUnitRunner.class)
public class ListarDetalhesDesafioResponseMapperTest {

    @InjectMocks
    ListarDetalhesDesafioResponseMapper tested;

    @Mock
    ModelMapper mapper;

    @Test
    public void deveAplicarMapeamento() {
        Desafio desafio = new Desafio();

        Mockito.when(mapper.map(desafio, ListarDetalhesDesafioResponse.class)).thenReturn(new ListarDetalhesDesafioResponse());

        ListarDetalhesDesafioResponse result =  tested.apply(desafio);

        Mockito.verify(mapper).map(desafio, ListarDetalhesDesafioResponse.class);
        Assert.assertNotNull(result);
    }
}