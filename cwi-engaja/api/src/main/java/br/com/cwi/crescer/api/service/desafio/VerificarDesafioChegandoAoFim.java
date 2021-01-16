package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class VerificarDesafioChegandoAoFim {

    @Autowired
    private Clock clock;

    public boolean isChegandoAoFim(Desafio desafio) {
        if(desafio.getDataLimite() != null){
            long daysDiff = DAYS.between(LocalDate.now(clock), desafio.getDataLimite());
            return (daysDiff <= 3 && daysDiff > 0);
        }
        return false;
    }
}
