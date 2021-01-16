package br.com.cwi.crescer.api.mapper.usuario;

import br.com.cwi.crescer.api.controller.responsedto.PerfilUsuarioResponse;
import br.com.cwi.crescer.api.domain.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class PerfilUsuarioResponseMapperTest {

    PerfilUsuarioResponseMapper tested;

    @Test
    public void deveAplicarMapeamento() {

        tested = new PerfilUsuarioResponseMapper();

        Usuario usuario = new Usuario();
        usuario.setNome("Joao Pedro");
        String nomeGestor = "Andre Nunes";

        PerfilUsuarioResponse result = tested.apply(usuario, nomeGestor);

        Assert.assertNotNull(result);
        Assert.assertEquals(usuario.getNome(), result.getNome());
        Assert.assertEquals(nomeGestor, result.getNomeGestor());
    }
}