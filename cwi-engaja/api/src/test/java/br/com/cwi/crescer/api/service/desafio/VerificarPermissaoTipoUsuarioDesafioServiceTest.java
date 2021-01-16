package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.TipoCargo;
import br.com.cwi.crescer.api.domain.TipoDesafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.service.usuario.BuscarEquipeDoUsuarioService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class VerificarPermissaoTipoUsuarioDesafioServiceTest {

    @InjectMocks
    VerificarPermissaoTipoUsuarioDesafioService tested;

    @Mock
    BuscarEquipeDoUsuarioService buscarEquipeService;

    Desafio desafio;
    Usuario criador;

    @Before
    public void setup() {
        desafio = new Desafio();
        criador = new Usuario();
        desafio.setUsuario(criador);
    }

    @Test
    public void devePermitirCriacaoDeDesafioGlobalParaRH() {
        criador.setCargo(TipoCargo.RH);
        desafio.setTipoDesafio(TipoDesafio.GLOBAL);

        tested.validar(desafio);
    }

    @Test
    public void devePermitirCriacaoDeDesafioGlobalParaADM() {
        criador.setCargo(TipoCargo.ADM);
        desafio.setTipoDesafio(TipoDesafio.GLOBAL);

        tested.validar(desafio);
    }

    @Test
    public void devePermitirCriacaoDeDesafioGlobalParaDiretor() {
        criador.setCargo(TipoCargo.DIRETOR);
        desafio.setTipoDesafio(TipoDesafio.GLOBAL);

        tested.validar(desafio);
    }

    @Test
    public void devePermitirCriacaoDeDesafioParaEquipeParaUsuarioQueTemEquipe() {
        criador.setCargo(TipoCargo.GESTOR);
        desafio.setTipoDesafio(TipoDesafio.EQUIPE);

        List<Usuario> equipe = new ArrayList<>();
        equipe.add(new Usuario());
        equipe.add(new Usuario());
        equipe.add(new Usuario());

        Mockito.when(buscarEquipeService.buscar(criador)).thenReturn(equipe);

        tested.validar(desafio);
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoUsuarioQueCriaDesafioForColaborador() {
        criador.setCargo(TipoCargo.COLABORADOR);

        try{
            tested.validar(desafio);
        }catch(ResponseStatusException e) {
            Assert.assertEquals("Usuário não possui permissão para criar desafio.", e.getReason());
            throw e;
        }

    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoGestorTentarCriarDesafioGlobal() {
        desafio.setTipoDesafio(TipoDesafio.GLOBAL);
        criador.setCargo(TipoCargo.GESTOR);

        try{
            tested.validar(desafio);
        }catch(ResponseStatusException e){
            Assert.assertEquals("Usuário não possui permissão para criar desafio global.", e.getReason());

            throw e;
        }
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoGerenteTentarCriarDesafioGlobal() {
        desafio.setTipoDesafio(TipoDesafio.GLOBAL);
        criador.setCargo(TipoCargo.GERENTE);

        try{
            tested.validar(desafio);
        }catch(ResponseStatusException e){
            Assert.assertEquals("Usuário não possui permissão para criar desafio global.", e.getReason());

            throw e;
        }
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoUsuarioSemEquipeTentarCriarDesafioParaEquipe() {
        desafio.setTipoDesafio(TipoDesafio.EQUIPE);

        List<Usuario> equipeVazia = new ArrayList<>();

        Mockito.when(buscarEquipeService.buscar(criador)).thenReturn(equipeVazia);

        try{
            tested.validar(desafio);
        }catch(ResponseStatusException e){
            Assert.assertEquals("Usuário não pode criar desafio para equipe, pois, o mesmo não possui equipe.", e.getReason());
            throw e;
        }
    }
}