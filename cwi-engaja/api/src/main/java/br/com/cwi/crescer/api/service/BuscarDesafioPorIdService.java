package br.com.cwi.crescer.api.service;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BuscarDesafioPorIdService {

    @Autowired
    DesafioRepository repository;

    public Desafio buscar(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Desafio não encontrado."));
    }
}
