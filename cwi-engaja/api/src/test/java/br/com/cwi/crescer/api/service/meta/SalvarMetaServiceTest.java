package br.com.cwi.crescer.api.service.meta;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioMeta;
import br.com.cwi.crescer.api.repository.DesafioMetaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class SalvarMetaServiceTest {

    @InjectMocks
    SalvarMetaService tested;

    @Mock
    DesafioMetaRepository repository;

    List<DesafioMeta> metas;
    Desafio desafio;

    @Before
    public void setup() {
        metas = new ArrayList<>();
        desafio = new Desafio();
    }

    @Test
    public void deveSalvarTresMetasComSucesso() {

        DesafioMeta metaUm = new DesafioMeta();
        metaUm.setQuantidadeColaboradores(10);
        metas.add(metaUm);
        DesafioMeta metaDois = new DesafioMeta();
        metaDois.setQuantidadeColaboradores(10);
        metas.add(metaDois);
        DesafioMeta metaTres = new DesafioMeta();
        metaTres.setQuantidadeColaboradores(10);
        metas.add(metaTres);

        tested.salvar(metas, desafio);

        Mockito.verify(repository, Mockito.times(3)).save(any());
    }
}