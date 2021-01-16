package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.controller.requestdto.DesafioRequest;
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
public class DesafioRequestMapperTest {

    @InjectMocks
    DesafioRequestMapper tested;

    @Mock
    ModelMapper modelMapper;

    @Test
    public void deveAplicarMapeamento() {
        DesafioRequest request = new DesafioRequest();

        Mockito.when(modelMapper.map(request, Desafio.class)).thenReturn(new Desafio());

        Desafio result = tested.apply(request);

        Mockito.verify(modelMapper).map(request, Desafio.class);

        Assert.assertNotNull(result);
    }
}