package br.com.cwi.crescer.api.service.usuario;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.DesafioUsuarioContribuicaoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class VerificarSeUsuarioJaContribuiuServiceTest {

    @InjectMocks
    VerificarSeUsuarioJaContribuiuService tested;

    @Mock
    DesafioUsuarioContribuicaoRepository repository;

    Desafio desafio;
    Usuario usuario;

    @Before
    public void setup() {
        usuario = new Usuario();
        desafio = new Desafio();
    }

    @Test
    public void deveRetornarVerdadeiroQuandoUsuarioJaContribuiu() {

        DesafioUsuarioContribuicao contribuicao = new DesafioUsuarioContribuicao();

        Mockito.when(repository.findByDesafioAndUsuario(desafio, usuario))
                .thenReturn(Optional.of(contribuicao));

        boolean result = tested.jaContribuiu(desafio, usuario);

        Mockito.verify(repository).findByDesafioAndUsuario(desafio, usuario);

        Assert.assertTrue(result);
    }

    @Test
    public void deveRetornarFalsoQuandoUsuarioNaoContribuiu() {

        Mockito.when(repository.findByDesafioAndUsuario(desafio, usuario))
                .thenReturn(Optional.empty());

        boolean result = tested.jaContribuiu(desafio, usuario);

        Mockito.verify(repository).findByDesafioAndUsuario(desafio, usuario);

        Assert.assertFalse(result);
    }
}