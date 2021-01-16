package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.TipoDesafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PermissaoVisualizacaoServiceTest {

    @InjectMocks
    PermissaoVisualizacaoService tested;

    @Mock
    BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Test
    public void deveValidarComSucessoQuandoTipoDesafioForGlobal() {

        Usuario usuario = new Usuario();
        Desafio desafio = new Desafio();
        desafio.setTipoDesafio(TipoDesafio.GLOBAL);

        Mockito.when(buscarUsuarioAutenticadoService.buscar())
                .thenReturn(usuario);

        tested.validar(desafio);

        Assert.assertNotNull(desafio);

    }

    @Test
    public void deveValidarComSucessoQuandoUsuarioForOCriador() {

        Usuario usuario = new Usuario();
        usuario.setNome("Jussara");
        Desafio desafio = new Desafio();
        desafio.setUsuario(usuario);
        desafio.setTipoDesafio(TipoDesafio.EQUIPE);

        Mockito.when(buscarUsuarioAutenticadoService.buscar())
                .thenReturn(usuario);

        tested.validar(desafio);

        Assert.assertNotNull(desafio);

    }

    @Test
    public void deveValidarComSucessoQuandoUsuarioForDaEquipeDoCriadorDoDesafio() {

        Usuario usuario = new Usuario();
        usuario.setNome("Marcos Henrique");
        usuario.setGestor("Jussara");

        Usuario gestor = new Usuario();
        gestor.setUser("jussara");

        Desafio desafio = new Desafio();
        desafio.setUsuario(gestor);
        desafio.setTipoDesafio(TipoDesafio.EQUIPE);

        Mockito.when(buscarUsuarioAutenticadoService.buscar())
                .thenReturn(usuario);

        tested.validar(desafio);

        Assert.assertNotNull(desafio);

    }

}
