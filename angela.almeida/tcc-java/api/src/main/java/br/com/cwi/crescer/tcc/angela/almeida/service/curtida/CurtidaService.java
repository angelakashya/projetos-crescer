package br.com.cwi.crescer.tcc.angela.almeida.service.curtida;

import br.com.cwi.crescer.tcc.angela.almeida.domain.Curtida;
import br.com.cwi.crescer.tcc.angela.almeida.domain.Postagem;
import br.com.cwi.crescer.tcc.angela.almeida.domain.Usuario;
import br.com.cwi.crescer.tcc.angela.almeida.repository.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurtidaService {

    @Autowired
    private CurtidaRepository repositorio;

    public Curtida save(Curtida c) {
        return repositorio.save(c);
    }

    public void delete(Curtida curtida) {
        repositorio.delete(curtida);
    }

    public Long countByIdPost(Integer idPost) {
        Postagem post = new Postagem();
        post.setId(idPost);

        return repositorio.countByIdPostagem(post);
    }

    public List<Curtida> findByIdUsuario(Integer idUsuario) {
        Usuario usuario = new Usuario();
        usuario.setId(idUsuario);

        return repositorio.findByIdUsuario(usuario);
    }

    public List<Curtida> findByIdPostagem(Integer idPostagem) {
        Postagem postagem = new Postagem();
        postagem.setId(idPostagem);

        return repositorio.findByIdPostagem(postagem);
    }

    public List<Curtida> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Curtida findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
