package br.com.cwi.crescer.melevaai.validator;

import br.com.cwi.crescer.melevaai.controller.request.PassageiroRequest;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;
import static org.apache.logging.log4j.util.Strings.isEmpty;

@Component
public class PassageiroRequestValidator {
    public void accept(PassageiroRequest request) {

        if(isNull(request)) {
            throw new ValidacaoNegocioException("Requisição Nula");
        }

        if(isNull(request.getEmail())) {
            throw new ValidacaoNegocioException("Email não pode ficar vazio.");
        }

        if(isNull(request.getCpf())) {
            throw new ValidacaoNegocioException("CPF não pode estar vazio");
        }

        if(isNull(request.getDataNascimento())) {
            throw new ValidacaoNegocioException("Data de nascimento não pode estar vazia");
        }
    }
}
