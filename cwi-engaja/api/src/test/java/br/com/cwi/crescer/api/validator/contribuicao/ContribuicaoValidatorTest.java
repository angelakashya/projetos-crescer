package br.com.cwi.crescer.api.validator.contribuicao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

@RunWith(MockitoJUnitRunner.class)
public class ContribuicaoValidatorTest {

    ContribuicaoValidator tested;

    @Before
    public void setup() {
        tested = new ContribuicaoValidator();
    }

    @Test
    public void deveValidarComSucesso() {
        String contribuicao = "10";

        tested.validar(contribuicao);
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoContribuicaoMenorQueZero() {
        String contribuicao = "-1";

        try{
            tested.validar(contribuicao);
        }catch(ResponseStatusException e){
            Assert.assertEquals("Contribuição deve ser maior que 0.", e.getReason());

            throw e;
        }
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoContribuicaoForZero(){
        String contribuicao = "0";

        try{
            tested.validar(contribuicao);
        }catch(ResponseStatusException e){
            Assert.assertEquals("Contribuição deve ser maior que 0.", e.getReason());

            throw e;
        }
    }
}