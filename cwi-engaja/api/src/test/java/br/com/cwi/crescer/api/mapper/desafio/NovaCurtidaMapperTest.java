package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.domain.Curtida;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Usuario;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NovaCurtidaMapperTest {

    NovaCurtidaMapper tested;

    @Test
    public void deveAplicarMapeamentoComSucesso() {
        tested = new NovaCurtidaMapper();


        Curtida curtida = new Curtida();

        Usuario usuario = new Usuario();

        Desafio desafio = new Desafio();

        Curtida result = tested.apply(curtida, usuario, desafio);

        Assert.assertNotNull(result);
        Assert.assertSame(usuario, result.getUsuario());
        Assert.assertSame(desafio, result.getDesafio());

    }
}