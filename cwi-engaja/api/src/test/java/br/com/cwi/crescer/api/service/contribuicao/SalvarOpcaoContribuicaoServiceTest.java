package br.com.cwi.crescer.api.service.contribuicao;

import br.com.cwi.crescer.api.controller.requestdto.DesafioRequest;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.repository.DesafioOpcaoContribuicaoRepository;
import br.com.cwi.crescer.api.validator.contribuicao.ListaOpcaoContribuicaoValidator;
import br.com.cwi.crescer.api.validator.contribuicao.OpcaoContribuicaoCadastradaValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class SalvarOpcaoContribuicaoServiceTest {

    @InjectMocks
    private SalvarOpcaoContribuicaoService tested;

    @Mock
    private ListaOpcaoContribuicaoValidator listaPreenchidaValidator;

    @Mock
    private OpcaoContribuicaoCadastradaValidator opcaoValidator;

    @Mock
    private DesafioOpcaoContribuicaoRepository desafioOpcaoContribuicaoRepository;

    @Mock
    SalvarOpcaoPadraoService salvarOpcaoPadrao;


    @Test
    public void deveSalvarOpcoesCorretamenteAoReceberOpcoesPreDefinidasNoRequest() {

        DesafioRequest desafioRequest = new DesafioRequest();
        List<DesafioOpcaoContribuicao> opcoesContribuicao = new ArrayList<>();
        DesafioOpcaoContribuicao opcao = new DesafioOpcaoContribuicao();
        opcoesContribuicao.add(opcao);
        desafioRequest.setDesafioOpcaoContribuicao(opcoesContribuicao);

        Desafio desafio = new Desafio();

        Mockito.when(listaPreenchidaValidator.validar(desafioRequest)).thenReturn(true);
        Mockito.when(opcaoValidator.validar(opcao)).thenReturn(true);



        List<DesafioOpcaoContribuicao> result = tested.salvar(desafioRequest, desafio);

        Mockito.verify(listaPreenchidaValidator).validar(desafioRequest);
        Mockito.verify(opcaoValidator).validar(opcao);
        Mockito.verify(desafioOpcaoContribuicaoRepository).save(opcao);
        Mockito.verify(salvarOpcaoPadrao, Mockito.never()).salvar(desafio);

        Assert.assertNotNull(result);
        Assert.assertEquals(opcao, result.get(0));
        Assert.assertEquals(desafio, result.get(0).getDesafio());
    }

    @Test
    public void deveSalvarContribuicaoPadraoQuandoNaoReceberOpcoesDeContribuicaoNoRequest() {
        DesafioRequest desafioRequest = new DesafioRequest();

        Desafio desafio = new Desafio();

        Mockito.when(listaPreenchidaValidator.validar(desafioRequest)).thenReturn(false);


        List<DesafioOpcaoContribuicao> result = tested.salvar(desafioRequest, desafio);

        Mockito.verify(listaPreenchidaValidator).validar(desafioRequest);
        Mockito.verify(opcaoValidator, Mockito.never()).validar(any());
        Mockito.verify(salvarOpcaoPadrao).salvar(desafio);

        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
    }
}