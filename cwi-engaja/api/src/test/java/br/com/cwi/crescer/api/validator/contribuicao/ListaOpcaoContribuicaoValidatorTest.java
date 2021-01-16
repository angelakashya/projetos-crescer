package br.com.cwi.crescer.api.validator.contribuicao;

import br.com.cwi.crescer.api.controller.requestdto.DesafioRequest;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListaOpcaoContribuicaoValidatorTest {

    ListaOpcaoContribuicaoValidator tested;
    DesafioRequest request;

    @Before
    public void setUp() {
        tested = new ListaOpcaoContribuicaoValidator();
        request = new DesafioRequest();
    }

    @Test
    public void deveRetornarVerdadeiroQuandoListaDeOpcoesDeContribuicaoTiverItens() {
        List<DesafioOpcaoContribuicao> opcoes = new ArrayList<>();
        opcoes.add(new DesafioOpcaoContribuicao());
        opcoes.add(new DesafioOpcaoContribuicao());
        request.setDesafioOpcaoContribuicao(opcoes);

        boolean result = tested.validar(request);

        Assert.assertTrue(result);
    }

    @Test
    public void deveRetornarFalsoQuandoListaDeOpcoesEstiverVazia() {
        List<DesafioOpcaoContribuicao> opcoes = new ArrayList<>();

        request.setDesafioOpcaoContribuicao(opcoes);

        boolean result = tested.validar(request);

        Assert.assertFalse(result);
    }

    @Test
    public void deveRetornarFalsoQuandoListaTiverUmItemComContribuicaoVazia() {

        List<DesafioOpcaoContribuicao> opcoes = new ArrayList<>();
        DesafioOpcaoContribuicao opcao = new DesafioOpcaoContribuicao();
        opcao.setContribuicao("");
        opcoes.add(opcao);
        request.setDesafioOpcaoContribuicao(opcoes);
        boolean result = tested.validar(request);

        Assert.assertFalse(result);
    }

    @Test
    public void deveRetornarFalsoQuandoListaForNula() {

        boolean result = tested.validar(request);

        Assert.assertFalse(result);
    }
}