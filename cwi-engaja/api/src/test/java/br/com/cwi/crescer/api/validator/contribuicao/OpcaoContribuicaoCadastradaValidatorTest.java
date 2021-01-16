package br.com.cwi.crescer.api.validator.contribuicao;

import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OpcaoContribuicaoCadastradaValidatorTest {

    OpcaoContribuicaoCadastradaValidator tested;

    @Test
    public void deveRetornarFalsoAoReceberContribuicaoVazia() {

        tested = new OpcaoContribuicaoCadastradaValidator();

        DesafioOpcaoContribuicao contribuicao = new DesafioOpcaoContribuicao();
        contribuicao.setContribuicao("");

        boolean result = tested.validar(contribuicao);

        Assert.assertFalse(result);
    }

    @Test
    public void deveRetornarVerdadeiroAoReceberContribuicaoComConteudo() {
        tested = new OpcaoContribuicaoCadastradaValidator();

        DesafioOpcaoContribuicao contribuicao = new DesafioOpcaoContribuicao();
        contribuicao.setContribuicao("10");

        boolean result = tested.validar(contribuicao);

        Assert.assertTrue(result);
    }
}