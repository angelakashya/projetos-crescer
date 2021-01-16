package br.com.cwi.crescer.tcc.angela.almeida.repository;

import br.com.cwi.crescer.tcc.angela.almeida.domain.Curtida;
import br.com.cwi.crescer.tcc.angela.almeida.domain.Postagem;
import br.com.cwi.crescer.tcc.angela.almeida.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CurtidaRepository extends CrudRepository<Curtida, Integer> {

    Curtida save(Curtida curtida);

    Optional<Curtida> findById(Integer id);

    Long countByIdPostagem(Postagem postagem);

    List<Curtida> findByIdUsuario(Usuario usuario);

    List<Curtida> findByIdPostagem(Postagem idPostagem);
}