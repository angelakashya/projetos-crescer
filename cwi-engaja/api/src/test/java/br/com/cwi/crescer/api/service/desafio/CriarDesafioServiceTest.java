package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.requestdto.DesafioRequest;
import br.com.cwi.crescer.api.controller.responsedto.DesafioResponse;
import br.com.cwi.crescer.api.domain.*;
import br.com.cwi.crescer.api.mapper.desafio.DesafioRequestMapper;
import br.com.cwi.crescer.api.mapper.desafio.DesafioResponseMapper;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import br.com.cwi.crescer.api.repository.UsuarioRepository;
import br.com.cwi.crescer.api.service.contribuicao.SalvarOpcaoContribuicaoService;
import br.com.cwi.crescer.api.service.meta.FiltrarMetasValidasService;
import br.com.cwi.crescer.api.service.meta.SalvarMetaService;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import br.com.cwi.crescer.api.service.usuario.PerfilUsuarioService;
import br.com.cwi.crescer.api.validator.desafio.DataLimiteCriacaoValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class CriarDesafioServiceTest {

    @InjectMocks
    CriarDesafioService tested;

    @Mock
    DesafioRequestMapper requestMapper;

    @Mock
    BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Mock
    VerificarPermissaoTipoUsuarioDesafioService verificarPermissaoTipoUsuarioDesafioService;

    @Mock
    DesafioRepository desafioRepository;

    @Mock
    SalvarMetaService salvarMetaService;

    @Mock
    SalvarOpcaoContribuicaoService salvarOpcaoContribuicaoService;

    @Mock
    DesafioResponseMapper responseMapper;

    @Mock
    DataLimiteCriacaoValidator dataLimiteValidator;

    @Mock
    UsuarioRepository usuarioRepository;

    @Mock
    FiltrarMetasValidasService filtrarMetasValidasService;

    @Test
    public void deveCriarDesafioComSucessoQuandoForDoTipoGlobal() {

        LocalDate dataLimite = LocalDate.parse("20-12-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        List<DesafioMeta> metas = new ArrayList<>();
        DesafioMeta meta = new DesafioMeta();
        Usuario usuario = new Usuario();

        usuario.setId(1);
        usuario.setNome("Jussara Terezinha");
        usuario.setEmail("jussara@cwi.com.br");
        usuario.setPosicao("Gerente");
        usuario.setCargo(TipoCargo.GERENTE);
        usuario.setGestor("James");
        usuario.setUser("jussara");

        List<DesafioOpcaoContribuicao> contribuicoes = new ArrayList<>();
        DesafioRequest request = new DesafioRequest();
        request.setTitulo("Natal para as Crianças de São Leopoldo");
        request.setDescricao("O objetivo é arrecadar cestas de natal");
        request.setDataLimite(dataLimite);
        request.setMetas(metas);
        request.setDesafioOpcaoContribuicao(contribuicoes);
        request.setTipoDesafio(TipoDesafio.GLOBAL);

        Desafio desafio = new Desafio();
        meta.setDesafio(desafio);
        meta.setQuantidadeColaboradores(100);
        meta.setRecompensa("Uma geladeira cheia de cervejas no sexto andar");
        metas.add(meta);
        desafio.setMetas(metas);
        desafio.setTitulo(request.getTitulo());
        desafio.setDescricao(request.getDescricao());
        desafio.setDataLimite(request.getDataLimite());
        desafio.setOpcaoContribuicao(request.getDesafioOpcaoContribuicao());
        desafio.setTipoDesafio(request.getTipoDesafio());
        desafio.setUsuario(usuario);
        desafio.setMaxParticipantes((long) 1100);

        DesafioResponse response = new DesafioResponse();
        response.setTitulo(request.getTitulo());
        response.setDescricao(request.getDescricao());
        response.setMeta(request.getMetas());
        response.setOpcaoContribuicao(request.getDesafioOpcaoContribuicao());
        response.setDataLimite(request.getDataLimite());
        response.setTipoDesafio(request.getTipoDesafio());
        response.setStatus(Status.ATIVO);

        Mockito.when(requestMapper.apply(request))
                .thenReturn(desafio);
        Mockito.when(buscarUsuarioAutenticadoService.buscar())
                .thenReturn(usuario);
        Mockito.when(usuarioRepository.count())
                .thenReturn(desafio.getMaxParticipantes());
        Mockito.when(filtrarMetasValidasService.filtrar(request, desafio.getMaxParticipantes()))
                .thenReturn(metas);
        Mockito.when(desafioRepository.save(desafio))
                .thenReturn(desafio);
        Mockito.when(salvarOpcaoContribuicaoService.salvar(request, desafio))
                .thenReturn(contribuicoes);
        Mockito.when(responseMapper.apply(desafio))
                .thenReturn(response);

        DesafioResponse result = tested.criar(request);

        Mockito.verify(requestMapper).apply(request);
        Mockito.verify(buscarUsuarioAutenticadoService).buscar();
        Mockito.verify(verificarPermissaoTipoUsuarioDesafioService).validar(desafio);
        Mockito.verify(dataLimiteValidator).validar(desafio);
        Mockito.verify(desafioRepository).save(desafio);
        Mockito.verify(salvarMetaService).salvar(metas, desafio);
        Mockito.verify(salvarOpcaoContribuicaoService).salvar(request, desafio);
        Mockito.verify(responseMapper).apply(desafio);

        Assert.assertNotNull(result);
        Assert.assertEquals("Natal para as Crianças de São Leopoldo", result.getTitulo());
        Assert.assertEquals("O objetivo é arrecadar cestas de natal", result.getDescricao());
        Assert.assertEquals(LocalDate.of(2020, 12, 20), result.getDataLimite());
        Assert.assertEquals(TipoDesafio.GLOBAL, result.getTipoDesafio());
        Assert.assertEquals(Status.ATIVO, result.getStatus());

    }

    @Test
    public void deveCriarDesafioComSucessoQuandoForDoTipoEquipe() {

        LocalDate dataLimite = LocalDate.parse("20-12-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        List<DesafioMeta> metas = new ArrayList<>();
        DesafioMeta meta = new DesafioMeta();
        Usuario usuario = new Usuario();

        usuario.setId(1);
        usuario.setNome("Jussara Terezinha");
        usuario.setEmail("jussara@cwi.com.br");
        usuario.setPosicao("Gerente");
        usuario.setCargo(TipoCargo.GERENTE);
        usuario.setGestor("James");
        usuario.setUser("jussara");

        List<DesafioOpcaoContribuicao> contribuicoes = new ArrayList<>();
        DesafioRequest request = new DesafioRequest();
        request.setTitulo("Natal para as Crianças de São Leopoldo");
        request.setDescricao("O objetivo é arrecadar cestas de natal");
        request.setDataLimite(dataLimite);
        request.setMetas(metas);
        request.setDesafioOpcaoContribuicao(contribuicoes);
        request.setTipoDesafio(TipoDesafio.EQUIPE);

        Desafio desafio = new Desafio();
        meta.setDesafio(desafio);
        meta.setQuantidadeColaboradores(100);
        meta.setRecompensa("Uma geladeira cheia de cervejas no sexto andar");
        metas.add(meta);
        desafio.setMetas(metas);
        desafio.setTitulo(request.getTitulo());
        desafio.setDescricao(request.getDescricao());
        desafio.setDataLimite(request.getDataLimite());
        desafio.setOpcaoContribuicao(request.getDesafioOpcaoContribuicao());
        desafio.setTipoDesafio(request.getTipoDesafio());
        desafio.setUsuario(usuario);
        desafio.setMaxParticipantes((long) 1100);

        DesafioResponse response = new DesafioResponse();
        response.setTitulo(request.getTitulo());
        response.setDescricao(request.getDescricao());
        response.setMeta(request.getMetas());
        response.setOpcaoContribuicao(request.getDesafioOpcaoContribuicao());
        response.setDataLimite(request.getDataLimite());
        response.setTipoDesafio(request.getTipoDesafio());
        response.setStatus(Status.ATIVO);

        Mockito.when(requestMapper.apply(request))
                .thenReturn(desafio);
        Mockito.when(buscarUsuarioAutenticadoService.buscar())
                .thenReturn(usuario);
        Mockito.when(usuarioRepository.countByGestor(usuario.getUser()))
                .thenReturn(desafio.getMaxParticipantes());
        Mockito.when(filtrarMetasValidasService.filtrar(any(DesafioRequest.class), any(Long.class)))
                .thenReturn(metas);
        Mockito.when(desafioRepository.save(desafio))
                .thenReturn(desafio);
        Mockito.when(salvarOpcaoContribuicaoService.salvar(request, desafio))
                .thenReturn(contribuicoes);
        Mockito.when(responseMapper.apply(desafio))
                .thenReturn(response);

        DesafioResponse result = tested.criar(request);

        Mockito.verify(requestMapper).apply(request);
        Mockito.verify(buscarUsuarioAutenticadoService).buscar();
        Mockito.verify(verificarPermissaoTipoUsuarioDesafioService).validar(desafio);
        Mockito.verify(dataLimiteValidator).validar(desafio);
        Mockito.verify(desafioRepository).save(desafio);
        Mockito.verify(salvarMetaService).salvar(metas, desafio);
        Mockito.verify(salvarOpcaoContribuicaoService).salvar(request, desafio);
        Mockito.verify(responseMapper).apply(desafio);

        Assert.assertNotNull(result);
        Assert.assertEquals("Natal para as Crianças de São Leopoldo", result.getTitulo());
        Assert.assertEquals("O objetivo é arrecadar cestas de natal", result.getDescricao());
        Assert.assertEquals(LocalDate.of(2020, 12, 20), result.getDataLimite());
        Assert.assertEquals(TipoDesafio.EQUIPE, result.getTipoDesafio());
        Assert.assertEquals(Status.ATIVO, result.getStatus());


    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExceptionQuandoNaoForInformadaPeloMenosUmaMeta() {

        List<DesafioMeta> metas = new ArrayList<>();

        LocalDate dataLimite = LocalDate.parse("20-12-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome("Jussara Terezinha");
        usuario.setEmail("jussara@cwi.com.br");
        usuario.setPosicao("Gerente");
        usuario.setCargo(TipoCargo.GERENTE);
        usuario.setGestor("James");
        usuario.setUser("jussara");

        List<DesafioOpcaoContribuicao> contribuicoes = new ArrayList<>();
        DesafioRequest request = new DesafioRequest();
        request.setTitulo("Natal para as Crianças de São Leopoldo");
        request.setDescricao("O objetivo é arrecadar cestas de natal");
        request.setDataLimite(dataLimite);
        request.setMetas(metas);
        request.setDesafioOpcaoContribuicao(contribuicoes);
        request.setTipoDesafio(TipoDesafio.EQUIPE);
        request.setMetas(metas);

        Desafio desafio = new Desafio();
        desafio.setMetas(metas);
        desafio.setTitulo(request.getTitulo());
        desafio.setDescricao(request.getDescricao());
        desafio.setDataLimite(request.getDataLimite());
        desafio.setOpcaoContribuicao(request.getDesafioOpcaoContribuicao());
        desafio.setTipoDesafio(request.getTipoDesafio());
        desafio.setUsuario(usuario);
        desafio.setMaxParticipantes((long) 25);

        DesafioResponse response = new DesafioResponse();
        response.setTitulo(request.getTitulo());
        response.setDescricao(request.getDescricao());
        response.setOpcaoContribuicao(request.getDesafioOpcaoContribuicao());
        response.setDataLimite(request.getDataLimite());
        response.setTipoDesafio(request.getTipoDesafio());
        response.setStatus(Status.ATIVO);
        response.setMeta(metas);

        Mockito.when(requestMapper.apply(request))
                .thenReturn(desafio);
        Mockito.when(buscarUsuarioAutenticadoService.buscar())
                .thenReturn(usuario);
        Mockito.when(usuarioRepository.countByGestor(usuario.getUser()) + PerfilUsuarioService.PROPRIO_USUARIO)
                .thenReturn(desafio.getMaxParticipantes());


        DesafioResponse result = tested.criar(request);

        Mockito.verify(requestMapper).apply(request);
        Mockito.verify(buscarUsuarioAutenticadoService).buscar();
        Mockito.verify(verificarPermissaoTipoUsuarioDesafioService).validar(desafio);
        Mockito.verify(dataLimiteValidator).validar(desafio);
        Mockito.verify(desafioRepository).save(desafio);
        Mockito.verify(salvarMetaService).salvar(metas, desafio);
        Mockito.verify(salvarOpcaoContribuicaoService).salvar(request, desafio);
        Mockito.verify(responseMapper).apply(desafio);

    }

}
