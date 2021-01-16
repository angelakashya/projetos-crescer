package br.com.cwi.crescer.tcc.angela.almeida.service.comentario;

import br.com.cwi.crescer.tcc.angela.almeida.domain.Comentario;
import br.com.cwi.crescer.tcc.angela.almeida.domain.Postagem;
import br.com.cwi.crescer.tcc.angela.almeida.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository repositorio;

    public Comentario save(Comentario a) {
        return repositorio.save(a);
    }

    public List<Comentario> findAll() {
        return (List<Comentario>) repositorio.findAll();
    }

    public Comentario findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Long countByIdPostagem(Integer idPostagem) {
        final Postagem post = new Postagem();
        post.setId(idPostagem);

        return repositorio.countByIdPostagem(post);
    }

    public List<Comentario> findAllByIdPost(Integer idPost) {
        final Postagem post = new Postagem();
        post.setId(idPost);

        return repositorio.findAllByIdPostagem(post);
    }

}
