package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.responsedto.ListarDetalhesDesafioResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.TipoDesafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioService;
import org.apache.catalina.mbeans.GlobalResourcesLifecycleListener;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ListarDetalhesDesafioServiceTest {

    @InjectMocks
    ListarDetalhesDesafioService tested;

    @Mock
    BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Mock
    DesafioRepository desafioRepository;

    @Mock
    GerarDetalhesService gerarDetalhes;

    @Mock
    BuscarUsuarioService buscarUsuarioService;

    Usuario usuario;
    Integer idDesafio;
    ListarDetalhesDesafioResponse response;

    @Before
    public void setup() {
        usuario = new Usuario();
        idDesafio = 3;
        response = new ListarDetalhesDesafioResponse();
    }

    @Test
    public void deveListarDetalhesDoDesafioGlobalCriadoPeloUsuarioCorretamente() {
        Desafio desafioGlobal = new Desafio();
        usuario.setUser("bellotti");
        desafioGlobal.setUsuario(usuario);

        Mockito.when(buscarUsuarioAutenticadoService.buscar()).thenReturn(usuario);
        Mockito.when(desafioRepository.findByIdAndTipoDesafio(idDesafio, TipoDesafio.GLOBAL)).thenReturn(Optional.of(desafioGlobal));
        Mockito.when(gerarDetalhes.gerar(desafioGlobal, usuario)).thenReturn(response);

        ListarDetalhesDesafioResponse result = tested.listarDesafioDetalhe(idDesafio);

        Mockito.verify(buscarUsuarioAutenticadoService).buscar();
        Mockito.verify(desafioRepository).findByIdAndTipoDesafio(idDesafio, TipoDesafio.GLOBAL);
        Mockito.verify(gerarDetalhes).gerar(desafioGlobal, usuario);

        Assert.assertNotNull(result);
    }

    @Test
    public void deveListarDetalhesDoDesafioGlobalNaoCriadoPeloUsuarioCorretamente() {
        Desafio desafioGlobal = new Desafio();
        Usuario criador = new Usuario();
        criador.setUser("james");
        usuario.setUser("bellotti");
        desafioGlobal.setUsuario(criador);

        Mockito.when(buscarUsuarioAutenticadoService.buscar()).thenReturn(usuario);
        Mockito.when(desafioRepository.findByIdAndTipoDesafio(idDesafio, TipoDesafio.GLOBAL)).thenReturn(Optional.of(desafioGlobal));
        Mockito.when(gerarDetalhes.gerar(desafioGlobal, usuario)).thenReturn(response);

        ListarDetalhesDesafioResponse result = tested.listarDesafioDetalhe(idDesafio);

        Mockito.verify(buscarUsuarioAutenticadoService).buscar();
        Mockito.verify(desafioRepository).findByIdAndTipoDesafio(idDesafio, TipoDesafio.GLOBAL);
        Mockito.verify(gerarDetalhes).gerar(desafioGlobal, usuario);

        Assert.assertNotNull(result);
    }

    @Test
    public void deveListarDetalhesDoDesafioDaEquipe() {
        usuario.setGestor("bellotti");
        Usuario gestor = new Usuario();
        Desafio desafioEquipe = new Desafio();

        Mockito.when(buscarUsuarioAutenticadoService.buscar()).thenReturn(usuario);
        Mockito.when(desafioRepository.findByIdAndTipoDesafio(idDesafio, TipoDesafio.GLOBAL)).thenReturn(Optional.empty());
        Mockito.when(buscarUsuarioService.buscar(usuario.getGestor())).thenReturn(gestor);
        Mockito.when(desafioRepository.findByIdAndUsuario(idDesafio, gestor)).thenReturn(Optional.of(desafioEquipe));
        Mockito.when(gerarDetalhes.gerar(desafioEquipe, usuario)).thenReturn(response);

        ListarDetalhesDesafioResponse result = tested.listarDesafioDetalhe(idDesafio);

        Mockito.verify(buscarUsuarioAutenticadoService).buscar();
        Mockito.verify(desafioRepository).findByIdAndTipoDesafio(idDesafio, TipoDesafio.GLOBAL);
        Mockito.verify(buscarUsuarioService).buscar(usuario.getGestor());
        Mockito.verify(desafioRepository).findByIdAndUsuario(idDesafio, gestor);
        Mockito.verify(gerarDetalhes).gerar(desafioEquipe, usuario);

        Assert.assertNotNull(result);
    }

    @Test
    public void deveListarDetalhesDoDesafioCriadoPeloUsuario() {
        Desafio meuDesafio = new Desafio();
        usuario.setGestor("james");
        meuDesafio.setTipoDesafio(TipoDesafio.EQUIPE);


        Mockito.when(buscarUsuarioAutenticadoService.buscar()).thenReturn(usuario);
        Mockito.when(desafioRepository.findByIdAndTipoDesafio(idDesafio, TipoDesafio.GLOBAL)).thenReturn(Optional.empty());
        Mockito.when(desafioRepository.findByIdAndUsuario(idDesafio, usuario)).thenReturn(Optional.of(meuDesafio));
        Mockito.when(gerarDetalhes.gerar(meuDesafio, usuario)).thenReturn(response);

        ListarDetalhesDesafioResponse result = tested.listarDesafioDetalhe(idDesafio);

        Mockito.verify(buscarUsuarioAutenticadoService).buscar();
        Mockito.verify(desafioRepository).findByIdAndTipoDesafio(idDesafio, TipoDesafio.GLOBAL);
        Mockito.verify(desafioRepository).findByIdAndUsuario(idDesafio, usuario);
        Mockito.verify(gerarDetalhes).gerar(meuDesafio, usuario);

        Assert.assertNotNull(result);

    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoNaoEncontrarDesafio() {

        usuario.setGestor("bellotti");
        Usuario gestor = new Usuario();

        Mockito.when(buscarUsuarioAutenticadoService.buscar()).thenReturn(usuario);
        Mockito.when(desafioRepository.findByIdAndTipoDesafio(idDesafio, TipoDesafio.GLOBAL))
                .thenReturn(Optional.empty());
        Mockito.when(buscarUsuarioService.buscar(usuario.getGestor())).thenReturn(gestor);
        Mockito.when(desafioRepository.findByIdAndUsuario(idDesafio, gestor)).thenReturn(Optional.empty());
        Mockito.when(desafioRepository.findByIdAndUsuario(idDesafio, usuario)).thenReturn(Optional.empty());

        try{
            tested.listarDesafioDetalhe(idDesafio);
        }catch(ResponseStatusException e) {

            Mockito.verify(buscarUsuarioAutenticadoService).buscar();
            Mockito.verify(desafioRepository).findByIdAndTipoDesafio(idDesafio, TipoDesafio.GLOBAL);
            Mockito.verify(buscarUsuarioService).buscar(usuario.getGestor());
            Mockito.verify(desafioRepository).findByIdAndUsuario(idDesafio, gestor);
            Mockito.verify(desafioRepository).findByIdAndUsuario(idDesafio, usuario);


            Assert.assertEquals("Não encontramos desafios para você.", e.getReason());

            throw e;

        }

    }
}