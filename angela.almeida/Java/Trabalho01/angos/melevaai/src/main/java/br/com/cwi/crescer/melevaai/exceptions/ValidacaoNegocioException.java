package br.com.cwi.crescer.melevaai.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidacaoNegocioException extends RuntimeException {

    public ValidacaoNegocioException() {
        super("Erro de negócio.");
    }
}


