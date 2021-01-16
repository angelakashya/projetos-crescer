package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Curtida;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DescurtirDesafioService {

    @Autowired
    private CurtidaRepository repository;

    public boolean descurtir(Desafio desafio, Usuario usuario) {
        Curtida curtida = repository
                .findByDesafioAndUsuario(desafio, usuario)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Algo deu errado ao descurtir."));
        repository.delete(curtida);
        return false;
    }
}
