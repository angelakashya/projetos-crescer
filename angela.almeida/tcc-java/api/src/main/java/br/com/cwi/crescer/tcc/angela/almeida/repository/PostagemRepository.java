package br.com.cwi.crescer.tcc.angela.almeida.repository;

import br.com.cwi.crescer.tcc.angela.almeida.domain.Postagem;
import br.com.cwi.crescer.tcc.angela.almeida.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface PostagemRepository extends PagingAndSortingRepository<Postagem, Integer> {

   Postagem save(Postagem postagem);

    Optional<Postagem> findById(Integer id);

    List<Postagem> findAll();

    List<Postagem> findAllByIdUsuario(Usuario u);

    Page<Postagem> findByIdUsuarioInOrderByIdDesc(List<Usuario> usuarios, Pageable pageable);
}
