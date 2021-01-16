package br.com.cwi.crescer.api.service.ranking;

import br.com.cwi.crescer.api.domain.Ranking;
import br.com.cwi.crescer.api.repository.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarRankingGlobalService {

    @Autowired
    private RankingRepository repository;

    public List<Ranking> buscar() {
        return repository.findFirst5By();
    }
}
