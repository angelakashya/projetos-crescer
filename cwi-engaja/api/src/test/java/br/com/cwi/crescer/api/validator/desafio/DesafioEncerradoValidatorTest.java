package br.com.cwi.crescer.api.validator.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Status;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.server.ResponseStatusException;

public class DesafioEncerradoValidatorTest {


    DesafioEncerradoValidator tested;

    Desafio desafio;

    @Before
    public void setUp(){
        tested = new DesafioEncerradoValidator();

        desafio = new Desafio();
    }

    @Test
    public void deveValidarComSucessoQuandoDesafioEstiverEncerrado() {
        desafio.setStatus(Status.ENCERRADO);

        tested.validar(desafio);
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoDesafioEstiverAtivo() {
        desafio.setStatus(Status.ATIVO);

        try{
            tested.validar(desafio);
        }catch(ResponseStatusException e){
            Assert.assertEquals("O desafio ainda está ativo.", e.getReason());

            throw e;
        }
    }
}