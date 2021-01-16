package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class CriadorDesafioValidator {

    public void validar(Desafio desafio, Usuario usuario) {
        if(!desafio.getUsuario().getId().equals(usuario.getId()))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "O desafio só pode ser encerrado pelo seu criador.");
    }
}
