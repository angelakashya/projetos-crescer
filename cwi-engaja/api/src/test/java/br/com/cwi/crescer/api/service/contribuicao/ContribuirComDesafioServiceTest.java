package br.com.cwi.crescer.api.service.contribuicao;

import br.com.cwi.crescer.api.controller.requestdto.NovaContribuicaoRequest;
import br.com.cwi.crescer.api.controller.responsedto.NovaContribuicaoResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.mapper.contribuicao.NovaContribuicaoMapper;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import br.com.cwi.crescer.api.repository.DesafioUsuarioContribuicaoRepository;
import br.com.cwi.crescer.api.service.desafio.BuscarDesafioPorIdService;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import br.com.cwi.crescer.api.service.usuario.VerificarUsuarioParticipanteService;
import br.com.cwi.crescer.api.validator.desafio.DataLimiteDesafioValidator;
import br.com.cwi.crescer.api.validator.desafio.DesafioAtivoValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ContribuirComDesafioServiceTest {

    @InjectMocks
    ContribuirComDesafioService tested;

    @Mock
    BuscarUsuarioAutenticadoService buscarUsuario;

    @Mock
    BuscarDesafioPorIdService buscarDesafio;

    @Mock
    DesafioAtivoValidator desafioAtivoValidator;

    @Mock
    DataLimiteDesafioValidator dataLimiteValidator;

    @Mock
    VerificarUsuarioParticipanteService verificarUsuarioParticipanteService;

    @Mock
    VerificarContribuicaoUsuarioService verificarNovaContribuicao;

    @Mock
    BuscarOpcaoContribuicaoService buscarOpcaoContribuicao;

    @Mock
    NovaContribuicaoMapper novaContribuicaoMapper;

    @Mock
    DesafioUsuarioContribuicaoRepository desafioUsuarioContribuicaoRepository;

    @Mock
    DesafioRepository desafioRepository;

    @Test
    public void deveContribuirComSucesso() {
        NovaContribuicaoRequest request = new NovaContribuicaoRequest();
        request.setIdDesafio(1);
        request.setContribuicao("10");

        Usuario usuario = new Usuario();
        Desafio desafio = new Desafio();
        desafio.setQuantidadeParticipantes(0);

        DesafioOpcaoContribuicao opcaoContribuicao = new DesafioOpcaoContribuicao();
        DesafioUsuarioContribuicao usuarioContribuicao = new DesafioUsuarioContribuicao();

        Mockito.when(buscarUsuario.buscar()).thenReturn(usuario);
        Mockito.when(buscarDesafio.buscar(request.getIdDesafio())).thenReturn(desafio);
        Mockito.when(buscarOpcaoContribuicao.buscar(desafio, request.getContribuicao())).thenReturn(opcaoContribuicao);
        Mockito.when(novaContribuicaoMapper.apply(desafio, usuario, opcaoContribuicao)).thenReturn(usuarioContribuicao);

        NovaContribuicaoResponse result = tested.contribuir(request);

        Mockito.verify(buscarUsuario).buscar();
        Mockito.verify(buscarDesafio).buscar(request.getIdDesafio());
        Mockito.verify(desafioAtivoValidator).validar(desafio);
        Mockito.verify(dataLimiteValidator).validar(desafio);
        Mockito.verify(verificarUsuarioParticipanteService).verificar(desafio);
        Mockito.verify(verificarNovaContribuicao).verificar(desafio, usuario);
        Mockito.verify(buscarOpcaoContribuicao).buscar(desafio, request.getContribuicao());
        Mockito.verify(novaContribuicaoMapper).apply(desafio, usuario, opcaoContribuicao);
        Mockito.verify(desafioUsuarioContribuicaoRepository).save(usuarioContribuicao);
        Mockito.verify(desafioRepository).save(desafio);


        Assert.assertNotNull(result);
        Assert.assertEquals(new Integer(1), result.getContribuicoes());

    }
}