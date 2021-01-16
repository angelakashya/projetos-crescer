package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.controller.responsedto.ResultadoDesafioResponse;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import br.com.cwi.crescer.api.domain.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class ResultadoDesafioSemOpcaoMapperTest {


    ResultadoDesafioSemOpcaoMapper tested;

    @Test
    public void deveAplicarMapeamento() {
        tested = new ResultadoDesafioSemOpcaoMapper();

        DesafioUsuarioContribuicao contribuicao = new DesafioUsuarioContribuicao();
        Usuario usuario = new Usuario();
        usuario.setNome("Taiane Schutz");
        contribuicao.setUsuario(usuario);

        ResultadoDesafioResponse result = tested.apply(contribuicao);

        Assert.assertNotNull(result);
        Assert.assertEquals(usuario.getNome(), result.getNome());
    }
}