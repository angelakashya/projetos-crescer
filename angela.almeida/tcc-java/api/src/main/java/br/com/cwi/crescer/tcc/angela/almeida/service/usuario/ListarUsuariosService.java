package br.com.cwi.crescer.tcc.angela.almeida.service.usuario;

import br.com.cwi.crescer.tcc.angela.almeida.domain.Usuario;
import br.com.cwi.crescer.tcc.angela.almeida.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarUsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listar() {

        return usuarioRepository.findAll();
    }
}
