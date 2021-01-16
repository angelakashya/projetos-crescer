package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Status;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import br.com.cwi.crescer.api.validator.desafio.CriadorDesafioValidator;
import br.com.cwi.crescer.api.validator.desafio.DesafioAtivoValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EncerrarDesafioServiceTest {

    @InjectMocks
    private EncerrarDesafioService tested;

    @Mock
    private BuscarDesafioPorIdService buscarDesafio;

    @Mock
    private DesafioAtivoValidator desafioAtivoValidator;

    @Mock
    private BuscarUsuarioAutenticadoService buscarUsuario;

    @Mock
    private CriadorDesafioValidator criadorValidator;

    @Mock
    DesafioRepository repository;

    @Test
    public void deveEncerrarDesafioComSucesso() {
        Integer idDesafio = 1;
        Desafio desafio = new Desafio();
        Usuario criador = new Usuario();

        Mockito.when(buscarDesafio.buscar(idDesafio)).thenReturn(desafio);
        Mockito.when(buscarUsuario.buscar()).thenReturn(criador);

        Desafio result = tested.encerrar(idDesafio);

        Mockito.verify(buscarDesafio).buscar(idDesafio);
        Mockito.verify(desafioAtivoValidator).validar(desafio);
        Mockito.verify(buscarUsuario).buscar();
        Mockito.verify(criadorValidator).validar(desafio, criador);
        Mockito.verify(repository).save(desafio);

        Assert.assertNotNull(result);
        Assert.assertEquals(Status.ENCERRADO, result.getStatus());
    }
}