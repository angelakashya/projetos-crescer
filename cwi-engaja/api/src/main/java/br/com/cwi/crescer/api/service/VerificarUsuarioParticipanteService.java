package br.com.cwi.crescer.api.service;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.TipoDesafio;
import br.com.cwi.crescer.api.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VerificarUsuarioParticipanteService {

    @Autowired
    BuscarUsuarioService buscarUsuario;

    public void verificar(Desafio desafio, Usuario usuario) {

        if(desafio.getUsuario().getId().equals(usuario.getId()) || desafio.getTipoDesafio().equals(TipoDesafio.GLOBAL))
            return;

        Usuario gestorUsuario = buscarUsuario.buscar(usuario.getGestor());
        if(desafio.getUsuario().getId().equals(gestorUsuario.getId()))
            return;

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O usuário não pode participar deste desafio.");
    }

}
