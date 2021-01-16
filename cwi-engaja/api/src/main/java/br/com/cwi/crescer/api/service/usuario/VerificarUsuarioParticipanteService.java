package br.com.cwi.crescer.api.service.usuario;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.service.desafio.PermissaoVisualizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VerificarUsuarioParticipanteService {

    @Autowired
    private PermissaoVisualizacaoService permissaoVisualizacaoService;

    public void verificar(Desafio desafio) {

        if ( !permissaoVisualizacaoService.validar(desafio) ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O usuário não possuí permissão.");
        }
    }

}
