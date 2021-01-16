package br.com.cwi.crescer.api.service.usuario;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.service.desafio.PermissaoVisualizacaoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class VerificarUsuarioParticipanteServiceTest {

    @InjectMocks
    VerificarUsuarioParticipanteService tested;

    @Mock
    PermissaoVisualizacaoService permissaoVisualizacaoService;

    Desafio desafio;

    @Before
    public void setup() {
        desafio = new Desafio();
    }

    @Test
    public void devePassarVerificacaoQuandoTiverPermissao() {

        Mockito.when(permissaoVisualizacaoService.validar(desafio)).thenReturn(true);

        tested.verificar(desafio);

        Mockito.verify(permissaoVisualizacaoService).validar(desafio);
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoNaoTiverPermissao() {

        Mockito.when(permissaoVisualizacaoService.validar(desafio)).thenReturn(false);

        try{
            tested.verificar(desafio);
        }catch(ResponseStatusException e) {

            Mockito.verify(permissaoVisualizacaoService).validar(desafio);

            Assert.assertEquals("O usuário não possuí permissão.", e.getReason());

            throw e;
        }

    }
}