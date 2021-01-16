package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.controller.requestdto.DesafioComentarioRequest;
import br.com.cwi.crescer.api.domain.DesafioComentario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DesafioComentarioRequestMapperTest {

    @InjectMocks
    DesafioComentarioRequestMapper tested;

    @Mock
    ModelMapper mapper;

    @Test
    public void deveAplicarMapeamentoComSucesso() {

        DesafioComentarioRequest request = new DesafioComentarioRequest();

        DesafioComentario response = new DesafioComentario();

        Mockito.when(mapper.map(request, DesafioComentario.class)).thenReturn(response);

        DesafioComentario result = tested.apply(request);

        Mockito.verify(mapper).map(request, DesafioComentario.class);

        Assert.assertNotNull(result);
    }
}