package br.com.cwi.crescer.api.service.usuario;

import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarNomeGestorService {

    @Autowired
    private UsuarioRepository repository;

    public String buscar(Usuario colaborador) {
        Optional<Usuario> gestor = repository.findByUser(colaborador.getGestor());
        if(gestor.isPresent())
            return gestor.get().getNome();
        return colaborador.getGestor();
    }
}
