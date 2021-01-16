package br.com.cwi.crescer.melevaai.service;

import org.springframework.stereotype.Service;

import br.com.cwi.crescer.melevaai.domain.CarteiraNacionalHabilitacao;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;

@Service
public class ValidarCnhService {

    public void validar(CarteiraNacionalHabilitacao cnh) {

        if (cnh.isVencida()) {
            throw new ValidacaoNegocioException("CNH vencida.");
        }
    }
}

