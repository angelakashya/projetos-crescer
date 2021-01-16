package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.controller.responsedto.ResultadoDesafioComOpcaoResponse;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import br.com.cwi.crescer.api.domain.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class ResultadoDesafioComOpcaoResponseMapperTest {

    ResultadoDesafioComOpcaoResponseMapper tested;

    @Test
    public void deveAplicarMapeamento() {
        tested = new ResultadoDesafioComOpcaoResponseMapper();

        DesafioUsuarioContribuicao contribuicao = new DesafioUsuarioContribuicao();
        Usuario usuario = new Usuario();
        DesafioOpcaoContribuicao opcaoContribuicao = new DesafioOpcaoContribuicao();
        usuario.setNome("João Pedro");
        opcaoContribuicao.setContribuicao("1");
        contribuicao.setDesafioOpcaoContribuicao(opcaoContribuicao);
        contribuicao.setUsuario(usuario);

        ResultadoDesafioComOpcaoResponse result =  tested.apply(contribuicao);

        Assert.assertNotNull(result);
        Assert.assertEquals(usuario.getNome(), result.getNome());
        Assert.assertEquals(opcaoContribuicao.getContribuicao(), result.getContribuicao());

    }
}