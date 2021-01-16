package br.com.cwi.crescer.api.service.prestacaodecontas;

import br.com.cwi.crescer.api.controller.requestdto.PrestacaoDeContasRequest;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioMeta;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.DesafioMetaRepository;
import br.com.cwi.crescer.api.service.desafio.BuscarDesafioPorIdService;
import br.com.cwi.crescer.api.service.meta.BuscarMetaPorIdService;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import br.com.cwi.crescer.api.validator.desafio.CriadorDesafioValidator;
import br.com.cwi.crescer.api.validator.desafio.DesafioEncerradoValidator;
import ch.qos.logback.core.net.AbstractSSLSocketAppender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.parameters.P;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PrestarContasServiceTest {

    @InjectMocks
    PrestarContasService tested;

    @Mock
    BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Mock
    BuscarDesafioPorIdService buscarDesafio;

    @Mock
    CriadorDesafioValidator criadorDesafioValidator;

    @Mock
    DesafioEncerradoValidator desafioEncerradoValidator;

    @Mock
    BuscarMetaPorIdService buscarMeta;

    @Mock
    DesafioMetaRepository repository;


    PrestacaoDeContasRequest request;
    Integer idDesafio;
    Usuario usuario;
    Desafio desafio;
    Integer idMeta;
    DesafioMeta meta;

    @Before
    public void setup() {
        request = new PrestacaoDeContasRequest();
        idDesafio = 1;
        usuario = new Usuario();
        desafio = new Desafio();
        meta = new DesafioMeta();
        idMeta = 1;
    }

    @Test
    public void devePrestarContasComSucessoQuandoInformarImagem() {

        request.setFoto("Imagem");
        request.setIdMeta(idMeta);

        Mockito.when(buscarUsuarioAutenticadoService.buscar()).thenReturn(usuario);
        Mockito.when(buscarDesafio.buscar(idDesafio)).thenReturn(desafio);
        Mockito.when(buscarMeta.buscar(idMeta)).thenReturn(meta);

        DesafioMeta metaAtualizada = tested.prestar(request, idDesafio);

        Mockito.verify(buscarDesafio).buscar(idDesafio);
        Mockito.verify(buscarUsuarioAutenticadoService).buscar();
        Mockito.verify(criadorDesafioValidator).validar(desafio, usuario);
        Mockito.verify(desafioEncerradoValidator).validar(desafio);
        Mockito.verify(buscarMeta).buscar(idMeta);
        Mockito.verify(repository).save(meta);

        Assert.assertNotNull(metaAtualizada);
        Assert.assertEquals(request.getFoto(), metaAtualizada.getImagemPrestacao());
        Assert.assertNull(metaAtualizada.getDescricaoPrestacao());
    }

    @Test
    public void devePrestarContasComSucessoQuandoInformarDescricao() {
        request.setDescricao("Descrição");
        request.setIdMeta(idMeta);

        Mockito.when(buscarUsuarioAutenticadoService.buscar()).thenReturn(usuario);
        Mockito.when(buscarDesafio.buscar(idDesafio)).thenReturn(desafio);
        Mockito.when(buscarMeta.buscar(idMeta)).thenReturn(meta);

        DesafioMeta metaAtualizada = tested.prestar(request, idDesafio);

        Mockito.verify(buscarDesafio).buscar(idDesafio);
        Mockito.verify(buscarUsuarioAutenticadoService).buscar();
        Mockito.verify(criadorDesafioValidator).validar(desafio, usuario);
        Mockito.verify(desafioEncerradoValidator).validar(desafio);
        Mockito.verify(buscarMeta).buscar(idMeta);
        Mockito.verify(repository).save(meta);

        Assert.assertNotNull(metaAtualizada);
        Assert.assertEquals(request.getDescricao(), metaAtualizada.getDescricaoPrestacao());
        Assert.assertNull(metaAtualizada.getImagemPrestacao());
    }

    @Test
    public void devePrestarContasComSucessoQuandoInformarDescricaoEImagem() {
        request.setFoto("Imagem");
        request.setDescricao("Descrição");
        request.setIdMeta(idMeta);

        Mockito.when(buscarUsuarioAutenticadoService.buscar()).thenReturn(usuario);
        Mockito.when(buscarDesafio.buscar(idDesafio)).thenReturn(desafio);
        Mockito.when(buscarMeta.buscar(idMeta)).thenReturn(meta);

        DesafioMeta metaAtualizada = tested.prestar(request, idDesafio);

        Mockito.verify(buscarDesafio).buscar(idDesafio);
        Mockito.verify(buscarUsuarioAutenticadoService).buscar();
        Mockito.verify(criadorDesafioValidator).validar(desafio, usuario);
        Mockito.verify(desafioEncerradoValidator).validar(desafio);
        Mockito.verify(buscarMeta).buscar(idMeta);
        Mockito.verify(repository).save(meta);

        Assert.assertNotNull(metaAtualizada);
        Assert.assertEquals(request.getFoto(), metaAtualizada.getImagemPrestacao());
        Assert.assertEquals(request.getDescricao(), metaAtualizada.getDescricaoPrestacao());
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoNaoInformarDescricaoNemImagem(){
        request.setIdMeta(idMeta);

        Mockito.when(buscarUsuarioAutenticadoService.buscar()).thenReturn(usuario);
        Mockito.when(buscarDesafio.buscar(idDesafio)).thenReturn(desafio);
        Mockito.when(buscarMeta.buscar(idMeta)).thenReturn(meta);

        try{
            tested.prestar(request, idDesafio);
        }catch(ResponseStatusException e){
            Mockito.verify(buscarDesafio).buscar(idDesafio);
            Mockito.verify(buscarUsuarioAutenticadoService).buscar();
            Mockito.verify(criadorDesafioValidator).validar(desafio, usuario);
            Mockito.verify(desafioEncerradoValidator).validar(desafio);
            Mockito.verify(buscarMeta).buscar(idMeta);

            Assert.assertEquals("É necessário informar a descrição e/ou a imagem para prestar contas.", e.getReason());
            throw e;
        }

    }
}