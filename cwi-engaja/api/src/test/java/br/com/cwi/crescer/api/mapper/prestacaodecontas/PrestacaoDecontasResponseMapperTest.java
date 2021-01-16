package br.com.cwi.crescer.api.mapper.prestacaodecontas;

import br.com.cwi.crescer.api.controller.responsedto.PrestacaoDeContasResponse;
import br.com.cwi.crescer.api.domain.DesafioMeta;
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
public class PrestacaoDecontasResponseMapperTest {

    @InjectMocks
    PrestacaoDecontasResponseMapper tested;

    @Mock
    ModelMapper mapper;

    @Test
    public void deveAplicarMapeamentoComSucesso() {

        DesafioMeta meta = new DesafioMeta();
        PrestacaoDeContasResponse response = new PrestacaoDeContasResponse();

        Mockito.when(mapper.map(meta, PrestacaoDeContasResponse.class)).thenReturn(response);

        PrestacaoDeContasResponse result = tested.apply(meta);

        Mockito.verify(mapper).map(meta, PrestacaoDeContasResponse.class);

        Assert.assertNotNull(result);
    }
}