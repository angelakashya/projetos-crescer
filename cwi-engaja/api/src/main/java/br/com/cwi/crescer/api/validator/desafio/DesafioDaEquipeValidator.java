package br.com.cwi.crescer.api.validator.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.TipoDesafio;
import org.springframework.stereotype.Component;

@Component
public class DesafioDaEquipeValidator {

    public boolean validar(Desafio desafio) {
        return desafio.getTipoDesafio().equals(TipoDesafio.EQUIPE);
    }
}
