package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.controller.responsedto.DesafioComentarioResponse;
import br.com.cwi.crescer.api.domain.DesafioComentario;
import br.com.cwi.crescer.api.domain.Usuario;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class DesafioComentarioResponseMapperTest {

    DesafioComentarioResponseMapper tested;

    @Test
    public void deveAplicarMapeamentoComSucesso() {

        tested = new DesafioComentarioResponseMapper();

        DesafioComentario comentario = new DesafioComentario();
        comentario.setDataCadastro(LocalDate.of(2020, 12, 12));
        comentario.setMensagem("Um comentário de teste!");

        Usuario comentou = new Usuario();
        comentou.setNome("João Pedro");
        comentario.setUsuario(comentou);

        DesafioComentarioResponse result = tested.apply(comentario);

        Assert.assertNotNull(result);
        Assert.assertEquals(comentou.getNome(), result.getUsuario());
        Assert.assertEquals(comentario.getDataCadastro(), result.getDataCadastro());
        Assert.assertEquals(comentario.getMensagem(), result.getMensagem());
    }
}