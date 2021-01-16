package br.com.cwi.crescer.tcc.angela.almeida.repository;

import br.com.cwi.crescer.tcc.angela.almeida.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    Usuario save(Usuario usuario);

    Optional<Usuario> findById(Integer id);

    List<Usuario> findAll();


    Usuario findOneByEmail(String email);

    List<Usuario> findByIdNotIn(List<Integer> amigos);
}
