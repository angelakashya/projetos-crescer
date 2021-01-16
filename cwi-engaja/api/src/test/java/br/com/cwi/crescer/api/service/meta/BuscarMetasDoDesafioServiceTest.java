package br.com.cwi.crescer.api.service.meta;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioMeta;
import br.com.cwi.crescer.api.repository.DesafioMetaRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.security.auth.DestroyFailedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BuscarMetasDoDesafioServiceTest {

    @InjectMocks
    BuscarMetasDoDesafioService tested;

    @Mock
    DesafioMetaRepository repository;

    Desafio desafio;

    @Before
    public void setup(){
        desafio = new Desafio();
    }

    @Test
    public void deveBuscarListaDeMetasPopulada() {
        List<DesafioMeta> metas = new ArrayList<>();
        DesafioMeta meta = new DesafioMeta();
        metas.add(meta);

        Mockito.when(repository.findByDesafio(desafio)).thenReturn(Optional.of(metas));

        List<DesafioMeta> result = tested.buscar(desafio);

        Mockito.verify(repository).findByDesafio(desafio);

        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void deveBuscarListaVazia() {

        Mockito.when(repository.findByDesafio(desafio)).thenReturn(Optional.empty());

        List<DesafioMeta> result = tested.buscar(desafio);

        Mockito.verify(repository).findByDesafio(desafio);

        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
    }
}