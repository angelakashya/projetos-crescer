package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Status;
import org.springframework.stereotype.Service;

@Service
public class VerificarDesafioValidoService {

    public boolean isAtivo(Desafio desafio) {
        return desafio.getStatus().equals(Status.ATIVO);
    }

}
