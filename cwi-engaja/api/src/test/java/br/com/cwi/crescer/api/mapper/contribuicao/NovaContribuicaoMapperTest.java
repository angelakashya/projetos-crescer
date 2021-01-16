package br.com.cwi.crescer.api.mapper.contribuicao;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import br.com.cwi.crescer.api.domain.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class NovaContribuicaoMapperTest {

    NovaContribuicaoMapper tested;

    @Test
    public void deveAplicarMapeamento() {

        tested = new NovaContribuicaoMapper();

        Desafio desafio = new Desafio();
        desafio.setId(1);
        Usuario usuario = new Usuario();
        usuario.setUser("joao.rocha");
        DesafioOpcaoContribuicao contribuicao = new DesafioOpcaoContribuicao();
        contribuicao.setContribuicao("10");

        DesafioUsuarioContribuicao result = tested.apply(desafio, usuario, contribuicao);

        Assert.assertNotNull(result);
        Assert.assertEquals(desafio.getId(), result.getDesafio().getId());
        Assert.assertEquals(usuario.getUser(), result.getUsuario().getUser());
        Assert.assertEquals(contribuicao.getContribuicao(), result.getDesafioOpcaoContribuicao().getContribuicao());
    }
}