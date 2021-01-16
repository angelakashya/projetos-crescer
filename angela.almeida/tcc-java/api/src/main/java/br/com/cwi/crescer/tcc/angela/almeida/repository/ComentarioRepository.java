package br.com.cwi.crescer.tcc.angela.almeida.repository;

import br.com.cwi.crescer.tcc.angela.almeida.domain.Comentario;
import br.com.cwi.crescer.tcc.angela.almeida.domain.Postagem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ComentarioRepository extends CrudRepository<Comentario, Integer> {

    Comentario save(Comentario comentario);

    Optional<Comentario> findById(Integer id);

    Long countByIdPostagem(Postagem postagem);

    List<Comentario> findAllByIdPostagem(Postagem idPostagem);
}
