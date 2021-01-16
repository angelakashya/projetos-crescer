package br.com.cwi.crescer.melevaai.validator;

import static java.util.Objects.isNull;
import static org.apache.logging.log4j.util.Strings.isEmpty;

import org.springframework.stereotype.Component;

import br.com.cwi.crescer.melevaai.controller.request.MotoristaRequest;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;

@Component
public class MotoristaRequestValidator {

    public void accept(MotoristaRequest request) {

        if (isNull(request)) {
            throw new ValidacaoNegocioException("Request nula.");
        }

        if (isNull(request.getCnh())) {
            throw new ValidacaoNegocioException("CNH nula.");
        }

        if (isEmpty(request.getCnh().getNumero())) {
            throw new ValidacaoNegocioException("Número CNH nulo ou vazio.");
        }

        if (isNull(request.getCnh().getDataVencimento())) {
            throw new ValidacaoNegocioException("Data de vencimento CNH nula.");
        }

        if (isNull(request.getCnh().getCategoria())) {
            throw new ValidacaoNegocioException("Categoria nula.");
        }

        if (isEmpty(request.getNome())) {
            throw new ValidacaoNegocioException("Nome nulo ou vazio.");
        }

        if (isNull(request.getDataNascimento())) {
            throw new ValidacaoNegocioException("Data de nascimento nulo.");
        }

        if (isEmpty(request.getCpf())) {
            throw new ValidacaoNegocioException("CPF nulo ou vazio.");
        }

        if (isEmpty(request.getEmail())) {
            throw new ValidacaoNegocioException("E-mail nulo ou vazio.");
        }
    }
}

