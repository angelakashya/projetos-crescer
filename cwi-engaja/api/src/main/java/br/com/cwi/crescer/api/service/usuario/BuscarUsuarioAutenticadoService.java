package br.com.cwi.crescer.api.service.usuario;

import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.security.UsuarioAutenticado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioAutenticadoService {
    @Autowired
    BuscarUsuarioService buscarUsuario;

    public Usuario buscar() {
        UsuarioAutenticado usuarioAutenticado =
                (UsuarioAutenticado) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return buscarUsuario.buscar(usuarioAutenticado.getUsuario());
    }
}
