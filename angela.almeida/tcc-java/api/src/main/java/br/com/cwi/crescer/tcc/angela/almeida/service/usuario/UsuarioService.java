package br.com.cwi.crescer.tcc.angela.almeida.service.usuario;

import br.com.cwi.crescer.tcc.angela.almeida.domain.Amigo;
import br.com.cwi.crescer.tcc.angela.almeida.domain.Usuario;
import br.com.cwi.crescer.tcc.angela.almeida.repository.UsuarioRepository;
import br.com.cwi.crescer.tcc.angela.almeida.service.amigo.AmigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repositorio;

    @Autowired
    private AmigoService amigoService;

    public Usuario save(Usuario u) {
        u.setSenha(new BCryptPasswordEncoder().encode(u.getSenha()));

        return repositorio.save(u);
    }

    public List<Usuario> findAll() {
        return (List<Usuario>) repositorio.findAll();
    }

    public Optional<Usuario> findById(Integer id) {
        return repositorio.findById(id);
    }

    public Usuario findByEmail(String email) {
        return repositorio.findOneByEmail(email);
    }

    public List<Usuario> findByIdUsuarioNotIn(Integer id) {
        List<Integer> amigos = new ArrayList<>();
        amigos.add(id);
        amigoService.findAllByIdUsuarioAndAceito(id, true)
                .stream()
                .map(Amigo::getIdAmigo)
                .map(Usuario::getId)
                .forEach(amigos::add);

        amigoService.findAllByIdUsuarioAndAceito(id, false)
                .stream()
                .map(Amigo::getIdAmigo)
                .map(Usuario::getId)
                .forEach(amigos::add);

        return repositorio.findByIdNotIn(amigos);
    }
}
