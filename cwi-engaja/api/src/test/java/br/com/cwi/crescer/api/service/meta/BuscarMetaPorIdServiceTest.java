package br.com.cwi.crescer.api.service.meta;

import br.com.cwi.crescer.api.domain.DesafioMeta;
import br.com.cwi.crescer.api.repository.DesafioMetaRepository;
import org.junit.Assert;
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
public class BuscarMetaPorIdServiceTest {

    @InjectMocks
    private BuscarMetaPorIdService tested;

    @Mock
    private DesafioMetaRepository repository;

    @Test
    public void deveBuscarMetaPorIdComSucesso() {
        Integer idMeta = 1;
        DesafioMeta meta = new DesafioMeta();

        Mockito.when(repository.findById(idMeta)).thenReturn(Optional.of(meta));

        DesafioMeta result = tested.buscar(idMeta);

        Mockito.verify(repository).findById(idMeta);

        Assert.assertNotNull(result);
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoAoNaoEncontrarMetaComIdInformado() {
        Integer idMeta = 1;

        Mockito.when(repository.findById(idMeta)).thenReturn(Optional.empty());

        try{
            tested.buscar(idMeta);
        }catch(ResponseStatusException e){
            Mockito.verify(repository).findById(idMeta);

            Assert.assertEquals("A meta informada não existe.", e.getReason());

            throw e;
        }
    }
}