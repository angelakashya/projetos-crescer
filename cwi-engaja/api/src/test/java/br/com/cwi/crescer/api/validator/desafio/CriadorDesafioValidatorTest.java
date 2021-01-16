package br.com.cwi.crescer.api.validator.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CriadorDesafioValidatorTest {

    CriadorDesafioValidator tested;
    Desafio desafio;
    Usuario usuario;

    @Before
    public void setup() {
        tested = new CriadorDesafioValidator();
        desafio = new Desafio();
        usuario = new Usuario();
    }

    @Test
    public void deveValidarComSucesso() {
        usuario.setId(1);
        desafio.setUsuario(usuario);

        tested.validar(desafio, usuario);
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoUsuarioNaoForCriadorDoDesafio() {
        usuario.setId(1);
        Usuario criador = new Usuario();
        criador.setId(2);
        desafio.setUsuario(criador);

        try{
            tested.validar(desafio, usuario);
        }catch(ResponseStatusException e){
            Assert.assertEquals("O desafio só pode ser encerrado pelo seu criador.", e.getReason());
            Assert.assertEquals(HttpStatus.FORBIDDEN, e.getStatus());

            throw e;
        }
    }
}