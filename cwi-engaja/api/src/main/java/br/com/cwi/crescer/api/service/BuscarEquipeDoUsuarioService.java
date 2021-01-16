package br.com.cwi.crescer.api.service;

import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarEquipeDoUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> buscar(Usuario usuario) {
        return usuarioRepository.findByGestor(usuario.getUser());
    }
}
