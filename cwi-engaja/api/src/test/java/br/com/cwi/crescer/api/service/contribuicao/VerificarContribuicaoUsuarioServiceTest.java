package br.com.cwi.crescer.api.service.contribuicao;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.DesafioUsuarioContribuicaoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class VerificarContribuicaoUsuarioServiceTest {

    @InjectMocks
    VerificarContribuicaoUsuarioService tested;

    @Mock
    DesafioUsuarioContribuicaoRepository repository;

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoUsuarioJaTiverContribuido() {

        Desafio desafio = new Desafio();
        Usuario usuario = new Usuario();

        DesafioUsuarioContribuicao contribuicao = new DesafioUsuarioContribuicao();

        Mockito.when(repository.findByDesafioAndUsuario(desafio, usuario)).thenReturn(Optional.of(contribuicao));

        try{
            tested.verificar(desafio, usuario);
        }catch(ResponseStatusException e){
            Mockito.verify(repository).findByDesafioAndUsuario(desafio, usuario);

            Assert.assertEquals("Usuário já contribuiu com esse desafio.", e.getReason());
            throw e;
        }

    }

    @Test
    public void deveVerificarComSucessoQuandoUsuarioNaoContribuiu() {
        Desafio desafio = new Desafio();
        Usuario usuario = new Usuario();

        Mockito.when(repository.findByDesafioAndUsuario(desafio, usuario)).thenReturn(Optional.empty());

        tested.verificar(desafio, usuario);

        Mockito.verify(repository).findByDesafioAndUsuario(desafio, usuario);
    }
}