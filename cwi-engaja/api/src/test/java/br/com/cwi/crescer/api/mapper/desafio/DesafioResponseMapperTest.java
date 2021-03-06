package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.controller.responsedto.DesafioResponse;
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
public class DesafioResponseMapperTest {

    @InjectMocks
    DesafioResponseMapper tested;

    @Mock
    ModelMapper modelMapper;


    @Test
    public void deveAplicarMapeamento() {
        Desafio desafio = new Desafio();

        Mockito.when(modelMapper.map(desafio, DesafioResponse.class)).thenReturn(new DesafioResponse());

        DesafioResponse result = tested.apply(desafio);

        Mockito.verify(modelMapper).map(desafio, DesafioResponse.class);

        Assert.assertNotNull(result);
    }
}