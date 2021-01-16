package br.com.cwi.crescer.api.service.contribuicao;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import br.com.cwi.crescer.api.repository.DesafioUsuarioContribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BuscarContribuicoesDoDesafioService {

    @Autowired
    private DesafioUsuarioContribuicaoRepository repository;

    public List<DesafioUsuarioContribuicao> buscar(Desafio desafio) {
        return repository
                .findByDesafio(desafio)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Algo deu errado ao buscar as contribuições do desafio."));
    }
}
