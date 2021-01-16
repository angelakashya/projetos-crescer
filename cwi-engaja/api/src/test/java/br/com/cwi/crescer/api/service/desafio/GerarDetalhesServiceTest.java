package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.responsedto.ListarDetalhesDesafioResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.mapper.desafio.ListarDetalhesDesafioResponseMapper;
import br.com.cwi.crescer.api.repository.CurtidaRepository;
import br.com.cwi.crescer.api.repository.DesafioComentarioRepository;
import br.com.cwi.crescer.api.service.contribuicao.BuscarOpcoesDeContribuicaoPreDefinidasService;
import br.com.cwi.crescer.api.service.meta.BuscarMetasDoDesafioService;
import br.com.cwi.crescer.api.service.usuario.VerificarSeUsuarioJaContribuiuService;
import br.com.cwi.crescer.api.validator.desafio.DesafioAtivoValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RunWith(MockitoJUnitRunner.class)
public class GerarDetalhesServiceTest {

    @InjectMocks
    GerarDetalhesService tested;

    @Mock
    VerificarSeUsuarioJaContribuiuService verificarSeUsuarioJaContribuiu;

    @Mock
    BuscarOpcoesDeContribuicaoPreDefinidasService buscarOpcoesDeContribuicao;

    @Mock
    BuscarMetasDoDesafioService buscarMetasDoDesafio;

    @Mock
    ListarDetalhesDesafioResponseMapper listarDetalhesDesafioMapper;

    @Mock
    DesafioAtivoValidator ativoValidator;

    @Mock
    VerificarPrestacaoDeContasService verificarPrestacaoDeContas;

    @Mock
    private DesafioComentarioRepository desafioComentarioRepository;

    @Mock
    private CurtidaRepository curtidaRepository;

    @Mock
    private VerificarSeUsuarioJaCurtiuService verificarCurtida;

    @Test
    public void deveGerarDetalhesDoDesafioAtivo() {

        Desafio desafio = new Desafio();
        Usuario usuario = new Usuario();

        Mockito.when(listarDetalhesDesafioMapper.apply(desafio)).thenReturn(new ListarDetalhesDesafioResponse());
        Mockito.when(desafioComentarioRepository.countByDesafio(desafio)).thenReturn(new Long(10));
        Mockito.when(curtidaRepository.countByDesafio(desafio)).thenReturn(new Long(10));


        ListarDetalhesDesafioResponse result =  tested.gerar(desafio, usuario);

        Mockito.verify(verificarSeUsuarioJaContribuiu).jaContribuiu(desafio, usuario);
        Mockito.verify(buscarOpcoesDeContribuicao).buscar(desafio);
        Mockito.verify(buscarMetasDoDesafio).buscar(desafio);
        Mockito.verify(listarDetalhesDesafioMapper).apply(desafio);
        Mockito.verify(ativoValidator).validar(desafio);
        Mockito.verify(verificarPrestacaoDeContas).verificar(desafio);
        Mockito.verify(desafioComentarioRepository).countByDesafio(desafio);
        Mockito.verify(curtidaRepository).countByDesafio(desafio);
        Mockito.verify(verificarCurtida).verificar(desafio, usuario);

        Assert.assertNotNull(result);
    }

    @Test
    public void deveGerarDetalhesDoDesafioEncerrado(){
        Desafio desafio = new Desafio();
        Usuario usuario = new Usuario();

        Mockito.when(listarDetalhesDesafioMapper.apply(desafio)).thenReturn(new ListarDetalhesDesafioResponse());
        Mockito.when(desafioComentarioRepository.countByDesafio(desafio)).thenReturn(new Long(10));
        Mockito.when(curtidaRepository.countByDesafio(desafio)).thenReturn(new Long(10));
        Mockito.doThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro")).when(ativoValidator).validar(desafio);

        ListarDetalhesDesafioResponse result =  tested.gerar(desafio, usuario);

        Mockito.verify(verificarSeUsuarioJaContribuiu).jaContribuiu(desafio, usuario);
        Mockito.verify(buscarOpcoesDeContribuicao).buscar(desafio);
        Mockito.verify(buscarMetasDoDesafio).buscar(desafio);
        Mockito.verify(listarDetalhesDesafioMapper).apply(desafio);
        Mockito.verify(ativoValidator).validar(desafio);
        Mockito.verify(verificarPrestacaoDeContas).verificar(desafio);
        Mockito.verify(desafioComentarioRepository).countByDesafio(desafio);
        Mockito.verify(curtidaRepository).countByDesafio(desafio);
        Mockito.verify(verificarCurtida).verificar(desafio, usuario);

        Assert.assertNotNull(result);
    }
}