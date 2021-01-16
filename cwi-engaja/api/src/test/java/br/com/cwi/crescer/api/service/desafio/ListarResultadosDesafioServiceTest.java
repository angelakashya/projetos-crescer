package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.responsedto.ResultadoDesafioResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import br.com.cwi.crescer.api.mapper.desafio.ResultadoDesafioComOpcaoResponseMapper;
import br.com.cwi.crescer.api.mapper.desafio.ResultadoDesafioSemOpcaoMapper;
import br.com.cwi.crescer.api.service.contribuicao.BuscarContribuicoesDoDesafioService;
import br.com.cwi.crescer.api.service.contribuicao.BuscarOpcoesDeContribuicaoPreDefinidasService;
import br.com.cwi.crescer.api.validator.desafio.DesafioEncerradoValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class ListarResultadosDesafioServiceTest {

    @InjectMocks
    ListarResultadosDesafioService tested;

    @Mock
    BuscarDesafioPorIdService buscarDesafio;

    @Mock
    DesafioEncerradoValidator validarEncerrado;

    @Mock
    BuscarContribuicoesDoDesafioService buscarContribuicoes;

    @Mock
    BuscarOpcoesDeContribuicaoPreDefinidasService buscarOpcoes;

    @Mock
    ResultadoDesafioSemOpcaoMapper resultadoSemOpcaoMapper;

    @Mock
    ResultadoDesafioComOpcaoResponseMapper resultadoComOpcaoMapper;

    List<DesafioUsuarioContribuicao> contribuicoes;
    List<DesafioOpcaoContribuicao> opcoes;
    Desafio desafio;
    Integer idDesafio;

    @Before
    public void setup() {
        desafio = new Desafio();
        idDesafio = 1;
        contribuicoes = new ArrayList<>();
        contribuicoes.add(new DesafioUsuarioContribuicao());
        contribuicoes.add(new DesafioUsuarioContribuicao());
        contribuicoes.add(new DesafioUsuarioContribuicao());
        opcoes = new ArrayList<>();
    }

    @Test
    public void deveListarDesafioSemOpcoesDeContribuicaoCorretamente() {

        Mockito.when(buscarDesafio.buscar(idDesafio)).thenReturn(desafio);
        Mockito.when(buscarContribuicoes.buscar(desafio)).thenReturn(contribuicoes);
        Mockito.when(buscarOpcoes.buscar(desafio)).thenReturn(opcoes);

        List<ResultadoDesafioResponse> result = tested.listar(idDesafio);

        Mockito.verify(buscarDesafio).buscar(idDesafio);
        Mockito.verify(validarEncerrado).validar(desafio);
        Mockito.verify(buscarOpcoes).buscar(desafio);
        Mockito.verify(resultadoSemOpcaoMapper, Mockito.times(contribuicoes.size())).apply(any(DesafioUsuarioContribuicao.class));
        Mockito.verifyZeroInteractions(resultadoComOpcaoMapper);

        Assert.assertNotNull(result);
        Assert.assertEquals(contribuicoes.size(), result.size());
    }

    @Test
    public void deveListarDesafioComOpcoesDeContribuicaoCorretamente() {
        opcoes.add(new DesafioOpcaoContribuicao());
        opcoes.add(new DesafioOpcaoContribuicao());
        opcoes.add(new DesafioOpcaoContribuicao());

        Mockito.when(buscarDesafio.buscar(idDesafio)).thenReturn(desafio);
        Mockito.when(buscarContribuicoes.buscar(desafio)).thenReturn(contribuicoes);
        Mockito.when(buscarOpcoes.buscar(desafio)).thenReturn(opcoes);

        List<ResultadoDesafioResponse> result = tested.listar(idDesafio);

        Mockito.verify(buscarDesafio).buscar(idDesafio);
        Mockito.verify(validarEncerrado).validar(desafio);
        Mockito.verify(buscarOpcoes).buscar(desafio);
        Mockito.verifyZeroInteractions(resultadoSemOpcaoMapper);
        Mockito.verify(resultadoComOpcaoMapper, Mockito.times(contribuicoes.size())).apply(any(DesafioUsuarioContribuicao.class));

        Assert.assertNotNull(result);
        Assert.assertEquals(contribuicoes.size(), result.size());
    }
}