package br.com.cwi.crescer.tcc.angela.almeida.repository;

import br.com.cwi.crescer.tcc.angela.almeida.domain.Amigo;

import java.util.List;

import br.com.cwi.crescer.tcc.angela.almeida.domain.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface AmigoRepository extends CrudRepository<Amigo, Integer> {

    List<Amigo> findAll();

    List<Amigo> findAllByIdUsuario(Usuario usuario);

    List<Amigo> findByIdUsuarioAndAceito(Usuario usuario, boolean aceito);

    Amigo findByIdUsuarioAndIdAmigo(Usuario idUsuario, Usuario idAmigo);

    Long countByIdAmigoAndAceito(Usuario usuario, boolean aceito);

    List<Amigo> findByIdAmigoAndAceito(Usuario usuario, boolean aceito);
}
