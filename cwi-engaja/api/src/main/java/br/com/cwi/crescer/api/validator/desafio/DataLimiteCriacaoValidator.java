package br.com.cwi.crescer.api.validator.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.Clock;
import java.time.LocalDate;

@Component
public class DataLimiteCriacaoValidator {

    @Autowired
    Clock clock;

    public void validar(Desafio desafio) {

        if(desafio.getDataLimite() == null)
            return;

        LocalDate dataLimite = desafio.getDataLimite();
        if(dataLimite.isBefore(LocalDate.now(clock)) || dataLimite.isEqual(LocalDate.now(clock)))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Data limite informada deve ser após a data de hoje.");
    }
}
