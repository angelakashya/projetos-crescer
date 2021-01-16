package br.com.cwi.crescer.api.repository;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioMeta;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;


public interface DesafioMetaRepository extends Repository<DesafioMeta, Integer> {
    DesafioMeta save(DesafioMeta desafioMeta);
    Optional<List<DesafioMeta>> findByDesafio(Desafio desafio);
}