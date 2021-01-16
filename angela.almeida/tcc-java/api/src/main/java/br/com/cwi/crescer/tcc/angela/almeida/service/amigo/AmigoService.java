package br.com.cwi.crescer.tcc.angela.almeida.service.amigo;

import br.com.cwi.crescer.tcc.angela.almeida.domain.Amigo;
import br.com.cwi.crescer.tcc.angela.almeida.domain.Usuario;
import br.com.cwi.crescer.tcc.angela.almeida.repository.AmigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmigoService {

    @Autowired
    private AmigoRepository amigoRepository;

    public void delete(Amigo amigo) {

        amigoRepository.delete(amigo);
    }

    public Amigo save(Amigo a) {
        if (a != null) {
            if (a.isAceito()) {
                atualizarAmizade(a);
            } else  {
                amigoRepository.delete(a);
                return null;
            }
        }
        return amigoRepository.save(a);
    }

    public List<Amigo> listarTodos() {
        return amigoRepository.findAll();
    }

    public List<Amigo> findAllByIdUsuario(Integer idUsuario) {
        final Usuario usuario = new Usuario();
        usuario.setId(idUsuario);

        return amigoRepository.findAllByIdUsuario(usuario);
    }

    public List<Amigo> findAllByIdUsuarioAndAceito(Integer idUsuario, boolean aceito) {
        final Usuario usuario = new Usuario();
        usuario.setId(idUsuario);

        List<Amigo> teste = amigoRepository.findByIdUsuarioAndAceito(usuario, aceito);
        return amigoRepository.findByIdUsuarioAndAceito(usuario, aceito);
    }

        public Optional<Amigo> findById(Integer id) {

        return amigoRepository.findById(id);
    }

    public Amigo findByIdUsuarioAndIdAmigo(Usuario idUsuario, Usuario idAmigo) {
        return amigoRepository.findByIdUsuarioAndIdAmigo(idUsuario, idAmigo);
    }

    public Long countByIdUsuarioAndAceito(Integer idUsuario, boolean aceito) {
        final Usuario usuario = new Usuario();
        usuario.setId(idUsuario);

        return amigoRepository.countByIdAmigoAndAceito(usuario, aceito);
    }

    private void atualizarAmizade(Amigo amigo) {
        Amigo amizadeInvertida = new Amigo();

        amizadeInvertida.setId(0);
        amizadeInvertida.setIdUsuario(amigo.getIdUsuario());
        amizadeInvertida.setIdAmigo(amigo.getIdAmigo());
        amizadeInvertida.setAceito(true);

        amigoRepository.save(amizadeInvertida);
    }

    public List<Amigo> findAllByIdAmigoAndAceito(Integer idUsuario, boolean aceito) {
        final Usuario usuario = new Usuario();
        usuario.setId(idUsuario);

        return amigoRepository.findByIdAmigoAndAceito(usuario, aceito);
    }
}

