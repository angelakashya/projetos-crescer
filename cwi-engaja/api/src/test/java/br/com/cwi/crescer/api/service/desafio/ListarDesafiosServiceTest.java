package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.responsedto.ListarDesafiosResponse;
import br.com.cwi.crescer.api.domain.*;
import br.com.cwi.crescer.api.mapper.desafio.ListaDesafioResponseMapper;
import br.com.cwi.crescer.api.repository.CurtidaRepository;
import br.com.cwi.crescer.api.repository.DesafioComentarioRepository;
import br.com.cwi.crescer.api.repository.DesafioMetaRepository;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioService;
import br.com.cwi.crescer.api.service.usuario.VerificarSeUsuarioJaContribuiuService;
import br.com.cwi.crescer.api.validator.desafio.DesafioDaEquipeValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ListarDesafiosServiceTest {

    @InjectMocks
    ListarDesafiosService tested;

    @Mock
    BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Mock
    DesafioRepository desafioRepository;

    @Mock
    BuscarUsuarioService buscarUsuarioService;

    @Mock
    DesafioMetaRepository desafioMetaRepository;

    @Mock
    VerificarSeUsuarioJaContribuiuService verificarSeUsuarioJaContribuiuService;

    @Mock
    ListaDesafioResponseMapper modelMapper;

    @Mock
    DesafioComentarioRepository desafioComentarioRepository;

    @Mock
    CurtidaRepository curtidaRepository;

    @Mock
    VerificarDesafioValidoService verificarDesafioValidoService;

    @Mock
    VerificarDesafioChegandoAoFim verificarDesafioChegandoAoFim;;

    @Mock
    DesafioDaEquipeValidator desafioDaEquipeValidator;

    @Mock
    VerificarSeUsuarioJaCurtiuService verificarCurtida;

    @Test
    public void deveListarDesafiosComSucessoQuandoGestorForJamesOuTesser() {
        Desafio desafio = new Desafio();
        List<Desafio> desafios = new ArrayList<>();
        List<DesafioMeta> metas = new ArrayList<>();
        ListarDesafiosResponse listarDesafiosResponse = new ListarDesafiosResponse();

        DesafioMeta meta = new DesafioMeta();
        meta.setDesafio(desafio);
        meta.setQuantidadeColaboradores(100);
        meta.setRecompensa("Uma geladeira cheia de cervejas no sexto andar");
        metas.add(meta);

        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome("Jussara Teresinha Costa Inacio");
        usuario.setUser("jussara");
        usuario.setEmail("jussara.inacio1@gmail.com");
        usuario.setGestor(Socios.JAMES.toString());
        usuario.setCargo(TipoCargo.GERENTE);
        usuario.setPosicao("Gerente de Sistemas");

        LocalDate dataLimite = LocalDate.parse("20-12-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        desafio.setTitulo("Natal para as Crianças de São Leopoldo");
        desafio.setDescricao("O objetivo é arrecadar cestas de natal");
        desafio.setDataLimite(dataLimite);
        desafio.setMetas(metas);
        desafio.setUsuario(usuario);
        desafio.setTipoDesafio(TipoDesafio.EQUIPE);
        desafios.add(desafio);

        Mockito.when(buscarUsuarioAutenticadoService.buscar())
                .thenReturn(usuario);
        Mockito.when(desafioRepository.findByUsuario(usuario))
                .thenReturn(Optional.of(desafios));
        Mockito.when(desafioRepository.findByTipoDesafioAndUsuarioNot(TipoDesafio.GLOBAL, usuario))
                .thenReturn(Optional.of(desafios));
        Mockito.when(curtidaRepository.countByDesafio(desafio))
                .thenReturn(desafio.getQuantidadeDeCurtidas());
        Mockito.when(desafioComentarioRepository.countByDesafio(desafio))
                .thenReturn(desafio.getQuantidadeDeComentarios());
        Mockito.when(modelMapper.apply(desafio))
                .thenReturn(listarDesafiosResponse);

        List<ListarDesafiosResponse> result = tested.listar();

        Mockito.verify(buscarUsuarioAutenticadoService).buscar();
        Mockito.verify(desafioRepository).findByUsuario(usuario);
        Mockito.verify(desafioComentarioRepository, Mockito.times(2)).countByDesafio(desafio);
        Mockito.verify(curtidaRepository, Mockito.times(2)).countByDesafio(desafio);
        Mockito.verify(verificarDesafioValidoService, Mockito.times(2)).isAtivo(desafio);
        Mockito.verify(verificarDesafioChegandoAoFim, Mockito.times(2)).isChegandoAoFim(desafio);
        Mockito.verify(verificarSeUsuarioJaContribuiuService, Mockito.times(2)).jaContribuiu(desafio, usuario);
        Mockito.verify(desafioDaEquipeValidator, Mockito.times(2)).validar(desafio);
        Mockito.verify(desafioMetaRepository, Mockito.times(2)).findByDesafio(desafio);
        Mockito.verify(modelMapper, Mockito.times(2)).apply(desafio);
        Mockito.verify(verificarCurtida, Mockito.times(2)).verificar(desafio, usuario);

        Assert.assertNotNull(result);
    }

}
