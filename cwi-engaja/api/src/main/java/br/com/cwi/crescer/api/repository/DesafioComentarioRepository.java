package br.com.cwi.crescer.api.repository;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioComentario;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface DesafioComentarioRepository extends Repository<DesafioComentario, Integer> {

    DesafioComentario save(DesafioComentario desafioComentario);

    Optional<List<DesafioComentario>> findByDesafio(Desafio desafio);

    Long countByDesafio(Desafio desafio);

}
