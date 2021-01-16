package br.com.cwi.crescer.tcc.angela.almeida.service.postagem;


import br.com.cwi.crescer.tcc.angela.almeida.domain.Postagem;
import br.com.cwi.crescer.tcc.angela.almeida.domain.Usuario;
import br.com.cwi.crescer.tcc.angela.almeida.repository.PostagemRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    public Postagem save(Postagem p) {
        return postagemRepository.save(p);
    }

    public List<Postagem> findAll() {
        return (List<Postagem>) postagemRepository.findAll();
    }

    public Postagem findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Postagem> findAllByIdUsuario(Integer idUsuario) {
        Usuario u = new Usuario();
        u.setId(idUsuario);

        return postagemRepository.findAllByIdUsuario(u);
    }

    public Page<Postagem> findByIdUsuarioInOrderByIdDesc(List<Usuario> usuarios, Pageable pageable) {

        return postagemRepository.findByIdUsuarioInOrderByIdDesc(usuarios, pageable);
    }
}
