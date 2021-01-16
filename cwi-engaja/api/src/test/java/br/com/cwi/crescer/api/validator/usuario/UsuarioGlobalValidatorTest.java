package br.com.cwi.crescer.api.validator.usuario;

import br.com.cwi.crescer.api.domain.TipoCargo;
import br.com.cwi.crescer.api.domain.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioGlobalValidatorTest {

    UsuarioGlobalValidator tested;
    Usuario usuario;

    @Before
    public void setUp() {
        tested = new UsuarioGlobalValidator();
        usuario = new Usuario();
    }

    @Test
    public void deveRetornarFalsoQuandoUsuarioForColaborador() {
        usuario.setCargo(TipoCargo.COLABORADOR);

        boolean result = tested.validar(usuario);

        Assert.assertFalse(result);
    }

    @Test
    public void deveRetornarFalsoQuandoUsuarioForGestor() {
        usuario.setCargo(TipoCargo.GESTOR);

        boolean result = tested.validar(usuario);

        Assert.assertFalse(result);
    }

    @Test
    public void deveRetornarFalsoQuandoUsuarioForGerente() {
        usuario.setCargo(TipoCargo.GERENTE);

        boolean result = tested.validar(usuario);

        Assert.assertFalse(result);
    }

    @Test
    public void deveRetornarVerdadeiroQuandoUsuarioForRH() {
        usuario.setCargo(TipoCargo.RH);

        boolean result = tested.validar(usuario);

        Assert.assertTrue(result);
    }

    @Test
    public void deveRetornarVerdadeiroQuandoUsuarioForADM() {
        usuario.setCargo(TipoCargo.ADM);

        boolean result = tested.validar(usuario);

        Assert.assertTrue(result);
    }

    @Test
    public void deveRetornarVerdadeiroQuandoUsuarioForDiretor() {
        usuario.setCargo(TipoCargo.DIRETOR);

        boolean result = tested.validar(usuario);

        Assert.assertTrue(result);
    }

}