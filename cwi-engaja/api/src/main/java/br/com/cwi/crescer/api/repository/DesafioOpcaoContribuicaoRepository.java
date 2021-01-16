package br.com.cwi.crescer.api.repository;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface DesafioOpcaoContribuicaoRepository extends Repository<DesafioOpcaoContribuicao, Integer> {

    Optional<DesafioOpcaoContribuicao> findByDesafioAndContribuicao(Desafio desafio, String contribuicao);
    DesafioOpcaoContribuicao save(DesafioOpcaoContribuicao desafioOpcaoContribuicao);
    Optional<List<DesafioOpcaoContribuicao>> findByDesafio(Desafio desafio);

}
