package br.com.cwi.crescer.api.validator.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Status;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class DesafioEncerradoValidator {

    public void validar(Desafio desafio) {
        if(!desafio.getStatus().equals(Status.ENCERRADO))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O desafio ainda está ativo.");
    }
}
