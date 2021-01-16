package br.com.cwi.crescer.api.validator.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.TipoDesafio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DesafioDaEquipeValidatorTest {

    DesafioDaEquipeValidator tested;

    @Before
    public void setup() {
        tested = new DesafioDaEquipeValidator();
    }

    @Test
    public void deveRetornarFalsoQuandoDesafioForGlobal() {

        Desafio desafio = new Desafio();
        desafio.setTipoDesafio(TipoDesafio.GLOBAL);

        boolean result = tested.validar(desafio);

        Assert.assertFalse(result);
    }

    @Test
    public void deveRetornarVerdadeiroQuandoDesafioForGlobal() {

        Desafio desafio = new Desafio();
        desafio.setTipoDesafio(TipoDesafio.EQUIPE);

        boolean result = tested.validar(desafio);

        Assert.assertTrue(result);
    }
}