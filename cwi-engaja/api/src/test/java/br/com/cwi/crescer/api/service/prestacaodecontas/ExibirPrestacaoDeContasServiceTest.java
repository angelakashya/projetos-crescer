package br.com.cwi.crescer.api.service.prestacaodecontas;

import br.com.cwi.crescer.api.controller.responsedto.PrestacaoDeContasResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioMeta;
import br.com.cwi.crescer.api.mapper.prestacaodecontas.PrestacaoDecontasResponseMapper;
import br.com.cwi.crescer.api.service.desafio.PermissaoVisualizacaoService;
import br.com.cwi.crescer.api.service.meta.BuscarMetaPorIdService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ExibirPrestacaoDeContasServiceTest {

    @InjectMocks
    ExibirPrestacaoDeContasService tested;

    @Mock
    BuscarMetaPorIdService buscarMeta;

    @Mock
    PermissaoVisualizacaoService permissaoVisualizacao;

    @Mock
    PrestacaoDecontasResponseMapper responseMapper;

    DesafioMeta meta;

    Integer idMeta;

    @Before
    public void setup() {
        meta = new DesafioMeta();
        meta.setDesafio(new Desafio());
        idMeta = 1;
    }

    @Test
    public void deveExibirPrestacaoDeContasComSucessoQuandoTiverDescricaoEImagem() {

        meta.setDescricaoPrestacao("Descrição prestação de contas.");
        meta.setImagemPrestacao("Imagem prestação.");

        PrestacaoDeContasResponse response = new PrestacaoDeContasResponse();

        Mockito.when(buscarMeta.buscar(idMeta)).thenReturn(meta);
        Mockito.when(responseMapper.apply(meta)).thenReturn(response);

        PrestacaoDeContasResponse result = tested.exibir(idMeta);

        Mockito.verify(buscarMeta).buscar(idMeta);
        Mockito.verify(responseMapper).apply(meta);

        Assert.assertNotNull(result);
    }

    @Test
    public void deveExibirPrestacaoDeContasComSucessoQuandoTiverDescricao() {
        meta.setDescricaoPrestacao("Descrição prestação de contas.");

        PrestacaoDeContasResponse response = new PrestacaoDeContasResponse();

        Mockito.when(buscarMeta.buscar(idMeta)).thenReturn(meta);
        Mockito.when(responseMapper.apply(meta)).thenReturn(response);

        PrestacaoDeContasResponse result = tested.exibir(idMeta);


        Mockito.verify(buscarMeta).buscar(idMeta);
        Mockito.verify(responseMapper).apply(meta);

        Assert.assertNotNull(result);
    }

    @Test
    public void deveExibirPrestacaoDeContasComSucessoQuandoTiverImagem() {

        meta.setImagemPrestacao("Imagem prestação.");

        PrestacaoDeContasResponse response = new PrestacaoDeContasResponse();

        Mockito.when(buscarMeta.buscar(idMeta)).thenReturn(meta);
        Mockito.when(responseMapper.apply(meta)).thenReturn(response);

        PrestacaoDeContasResponse result = tested.exibir(idMeta);

        Mockito.verify(buscarMeta).buscar(idMeta);
        Mockito.verify(responseMapper).apply(meta);

        Assert.assertNotNull(result);
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoPrestacaoDeContasNaoTiverImagemNemDescricao() {

        Mockito.when(buscarMeta.buscar(idMeta)).thenReturn(meta);

        try{
            tested.exibir(idMeta);
        }catch(ResponseStatusException e){

            Mockito.verify(buscarMeta).buscar(idMeta);

            Assert.assertEquals("A meta não possuí prestação de contas.", e.getReason());

            throw e;
        }
    }
}