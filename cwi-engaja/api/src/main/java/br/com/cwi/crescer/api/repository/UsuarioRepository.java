package br.com.cwi.crescer.api.repository;

import br.com.cwi.crescer.api.domain.Usuario;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends Repository<Usuario, Integer> {

    List<Usuario> findByGestor(String gestor);
    Optional<Usuario> findByUser(String usuario);
    Optional<Usuario> findById(Integer id);
}
