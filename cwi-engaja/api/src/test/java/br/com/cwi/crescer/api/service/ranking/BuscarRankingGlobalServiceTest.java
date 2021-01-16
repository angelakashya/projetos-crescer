package br.com.cwi.crescer.api.service.ranking;

import br.com.cwi.crescer.api.domain.Ranking;
import br.com.cwi.crescer.api.repository.RankingRepository;
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
public class BuscarRankingGlobalServiceTest {

    @InjectMocks
    BuscarRankingGlobalService tested;

    @Mock
    RankingRepository repository;

    @Test
    public void deveBuscarRankingGlobalComSucesso() {

        Ranking rankUm = new Ranking();
        List<Ranking> response = new ArrayList<>();
        response.add(rankUm);

        Mockito.when(repository.findFirst5By()).thenReturn(response);

        List<Ranking> result = tested.buscar();

        Mockito.verify(repository).findFirst5By();

        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());

    }
}