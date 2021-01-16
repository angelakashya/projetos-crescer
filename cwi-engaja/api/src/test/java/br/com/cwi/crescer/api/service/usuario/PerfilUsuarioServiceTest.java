package br.com.cwi.crescer.api.service.usuario;

import br.com.cwi.crescer.api.controller.responsedto.PerfilUsuarioResponse;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.mapper.usuario.PerfilUsuarioResponseMapper;
import br.com.cwi.crescer.api.repository.UsuarioRepository;
import br.com.cwi.crescer.api.validator.usuario.UsuarioGlobalValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PerfilUsuarioServiceTest {

    @InjectMocks
    PerfilUsuarioService tested;

    @Mock
    BuscarUsuarioAutenticadoService buscarUsuarioAutenticado;

    @Mock
    BuscarNomeGestorService buscarNomeGestor;

    @Mock
    PerfilUsuarioResponseMapper perfilUsuarioResponseMapper;

    @Mock
    UsuarioGlobalValidator globalValidator;

    @Mock
    BuscarEquipeDoUsuarioService equipeService;

    @Mock
    UsuarioRepository usuarioRepository;

    @Test
    public void deveGerarPerfilGlobalSemSerGestorCorretamente() {
        Usuario usuario = new Usuario();
        usuario.setUser("joao.rocha");
        usuario.setPosicao("Estagiário de Programação");
        String nomeGestor = "andrenunes";

        Mockito.when(buscarUsuarioAutenticado.buscar()).thenReturn(usuario);
        Mockito.when(buscarNomeGestor.buscar(usuario)).thenReturn(nomeGestor);
        Mockito.when(perfilUsuarioResponseMapper.apply(usuario, nomeGestor)).thenReturn(new PerfilUsuarioResponse());
        Mockito.when(globalValidator.validar(usuario)).thenReturn(true);
        Mockito.when(equipeService.buscar(usuario)).thenReturn(new ArrayList<>());
        Mockito.when(usuarioRepository.count()).thenReturn(new Long(1100));

        PerfilUsuarioResponse result = tested.buscar();

        Mockito.verify(buscarUsuarioAutenticado).buscar();
        Mockito.verify(buscarNomeGestor).buscar(usuario);
        Mockito.verify(perfilUsuarioResponseMapper).apply(usuario, nomeGestor);
        Mockito.verify(globalValidator).validar(usuario);
        Mockito.verify(equipeService).buscar(usuario);
        Mockito.verify(usuarioRepository).count();
        Mockito.verify(usuarioRepository, Mockito.never()).countByGestor(usuario.getUser());

        Assert.assertNotNull(result);
        Assert.assertTrue(result.getIsGlobal());
        Assert.assertFalse(result.getIsGestor());
        Assert.assertEquals(new Long(1100), result.getTamanhoCwi());
        Assert.assertEquals(usuario.getPosicao(), result.getPosicao());

    }

    @Test
    public void deveGerarPerfilGlobalEGestorCorretamente() {
        Usuario usuario = new Usuario();
        usuario.setUser("joao.rocha");
        usuario.setPosicao("Estagiário de Programação");
        String nomeGestor = "andrenunes";
        List<Usuario> equipe = new ArrayList<>();
        equipe.add(new Usuario());

        Mockito.when(buscarUsuarioAutenticado.buscar()).thenReturn(usuario);
        Mockito.when(buscarNomeGestor.buscar(usuario)).thenReturn(nomeGestor);
        Mockito.when(perfilUsuarioResponseMapper.apply(usuario, nomeGestor)).thenReturn(new PerfilUsuarioResponse());
        Mockito.when(globalValidator.validar(usuario)).thenReturn(true);
        Mockito.when(equipeService.buscar(usuario)).thenReturn(equipe);
        Mockito.when(usuarioRepository.count()).thenReturn(new Long(1100));
        Mockito.when(usuarioRepository.countByGestor(usuario.getUser())).thenReturn(new Long(10));

        PerfilUsuarioResponse result = tested.buscar();

        Mockito.verify(buscarUsuarioAutenticado).buscar();
        Mockito.verify(buscarNomeGestor).buscar(usuario);
        Mockito.verify(perfilUsuarioResponseMapper).apply(usuario, nomeGestor);
        Mockito.verify(globalValidator).validar(usuario);
        Mockito.verify(equipeService).buscar(usuario);
        Mockito.verify(usuarioRepository).count();
        Mockito.verify(usuarioRepository).countByGestor(usuario.getUser());

        Assert.assertNotNull(result);
        Assert.assertTrue(result.getIsGlobal());
        Assert.assertTrue(result.getIsGestor());
        Assert.assertEquals(new Long(1100), result.getTamanhoCwi());
        Assert.assertEquals(new Long(11), result.getTamanhoEquipe());
        Assert.assertEquals(usuario.getPosicao(), result.getPosicao());

    }

    @Test
    public void deveGerarPerfilSemSerGlobalESemSerGestorCorretamente() {
        Usuario usuario = new Usuario();
        usuario.setUser("joao.rocha");
        usuario.setPosicao("Estagiário de Programação");
        String nomeGestor = "andrenunes";


        Mockito.when(buscarUsuarioAutenticado.buscar()).thenReturn(usuario);
        Mockito.when(buscarNomeGestor.buscar(usuario)).thenReturn(nomeGestor);
        Mockito.when(perfilUsuarioResponseMapper.apply(usuario, nomeGestor)).thenReturn(new PerfilUsuarioResponse());
        Mockito.when(globalValidator.validar(usuario)).thenReturn(false);
        Mockito.when(equipeService.buscar(usuario)).thenReturn(new ArrayList<>());

        PerfilUsuarioResponse result = tested.buscar();

        Mockito.verify(buscarUsuarioAutenticado).buscar();
        Mockito.verify(buscarNomeGestor).buscar(usuario);
        Mockito.verify(perfilUsuarioResponseMapper).apply(usuario, nomeGestor);
        Mockito.verify(globalValidator).validar(usuario);
        Mockito.verify(equipeService).buscar(usuario);
        Mockito.verify(usuarioRepository, Mockito.never()).count();
        Mockito.verify(usuarioRepository, Mockito.never()).countByGestor(usuario.getUser());

        Assert.assertNotNull(result);
        Assert.assertFalse(result.getIsGlobal());
        Assert.assertFalse(result.getIsGestor());
        Assert.assertNull(result.getTamanhoCwi());
        Assert.assertNull(result.getTamanhoEquipe());
        Assert.assertEquals(usuario.getPosicao(), result.getPosicao());
    }

    @Test
    public void deveGerarPerfilGestorSemSerGlobalCorretamente() {
        Usuario usuario = new Usuario();
        usuario.setUser("joao.rocha");
        usuario.setPosicao("Estagiário de Programação");
        String nomeGestor = "andrenunes";
        List<Usuario> equipe = new ArrayList<>();
        equipe.add(new Usuario());

        Mockito.when(buscarUsuarioAutenticado.buscar()).thenReturn(usuario);
        Mockito.when(buscarNomeGestor.buscar(usuario)).thenReturn(nomeGestor);
        Mockito.when(perfilUsuarioResponseMapper.apply(usuario, nomeGestor)).thenReturn(new PerfilUsuarioResponse());
        Mockito.when(globalValidator.validar(usuario)).thenReturn(false);
        Mockito.when(equipeService.buscar(usuario)).thenReturn(equipe);
        Mockito.when(usuarioRepository.countByGestor(usuario.getUser())).thenReturn(new Long(10));

        PerfilUsuarioResponse result = tested.buscar();

        Mockito.verify(buscarUsuarioAutenticado).buscar();
        Mockito.verify(buscarNomeGestor).buscar(usuario);
        Mockito.verify(perfilUsuarioResponseMapper).apply(usuario, nomeGestor);
        Mockito.verify(globalValidator).validar(usuario);
        Mockito.verify(equipeService).buscar(usuario);
        Mockito.verify(usuarioRepository, Mockito.never()).count();
        Mockito.verify(usuarioRepository).countByGestor(usuario.getUser());

        Assert.assertNotNull(result);
        Assert.assertFalse(result.getIsGlobal());
        Assert.assertTrue(result.getIsGestor());
        Assert.assertNull(result.getTamanhoCwi());
        Assert.assertEquals(new Long(11), result.getTamanhoEquipe());
        Assert.assertEquals(usuario.getPosicao(), result.getPosicao());
    }

}