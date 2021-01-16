package br.com.cwi.crescer.api.service.ranking;

import br.com.cwi.crescer.api.domain.Ranking;
import br.com.cwi.crescer.api.repository.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarRankingEquipeService {

    @Autowired
    private RankingRepository repository;

    public List<Ranking> buscar(String gestor) {
        return repository.findFirst5ByGestor(gestor);
    }
}
