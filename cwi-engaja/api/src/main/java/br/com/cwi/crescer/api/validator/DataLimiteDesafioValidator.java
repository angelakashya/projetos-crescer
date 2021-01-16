package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.domain.Desafio;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Component
public class DataLimiteDesafioValidator {

    public void validar(Desafio desafio){
        if(desafio.getDataLimite().isBefore(LocalDateTime.now()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data limite de contribuição já passou.");
    }
}
