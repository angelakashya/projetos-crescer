package br.com.cwi.crescer.api.validator.contribuicao;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ContribuicaoValidator {

    public void validar(String contribuicao) {
        if(Double.parseDouble(contribuicao) <= 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contribuição deve ser maior que 0.");
    }
}
