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
public class BuscarRankingEquipeServiceTest {

    @InjectMocks
    BuscarRankingEquipeService tested;

    @Mock
    RankingRepository repository;

    @Test
    public void deveBuscarRankingComSucesso() {

        String gestor = "andrenunes";
        Ranking rankUm = new Ranking();
        List<Ranking> response = new ArrayList<>();
        response.add(rankUm);

        Mockito.when(repository.findFirst5ByGestor(gestor)).thenReturn(response);

        List<Ranking> ranking = tested.buscar(gestor);

        Mockito.verify(repository).findFirst5ByGestor(gestor);

        Assert.assertNotNull(ranking);
        Assert.assertFalse(ranking.isEmpty());
    }
}