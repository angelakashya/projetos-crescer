package br.com.cwi.crescer.api.repository;

import br.com.cwi.crescer.api.domain.Curtida;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CurtidaRepository extends CrudRepository<Curtida, Integer> {

    Curtida save(Curtida curtida);

    void delete(Curtida curtida);

    Optional<Curtida> findByDesafioAndUsuario(Desafio desafio, Usuario usuario);

    Long countByDesafio(Desafio desafio);

}


