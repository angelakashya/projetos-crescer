package br.com.cwi.crescer.api.repository;

import br.com.cwi.crescer.api.domain.Ranking;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RankingRepository extends Repository<Ranking, Integer> {

    List<Ranking> findFirst5By();

    List<Ranking> findFirst5ByGestor(String gestor);

}
