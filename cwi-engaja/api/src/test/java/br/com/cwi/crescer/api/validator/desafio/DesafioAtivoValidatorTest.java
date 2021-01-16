package br.com.cwi.crescer.api.validator.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Status;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.server.ResponseStatusException;

public class DesafioAtivoValidatorTest {

    DesafioAtivoValidator tested;
    Desafio desafio;

    @Before
    public void setup() {
        tested = new DesafioAtivoValidator();
        desafio = new Desafio();
    }
    @Test
    public void deveValidarComSucessoQuandoDesafioEstiverAtivo() {
        desafio.setStatus(Status.ATIVO);

        tested.validar(desafio);
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoDesafioEstiverEncerrado() {
        desafio.setStatus(Status.ENCERRADO);

        try{
            tested.validar(desafio);
        }catch(ResponseStatusException e){
            Assert.assertEquals("O desafio já foi encerrado.", e.getReason());
            throw e;
        }

    }
}