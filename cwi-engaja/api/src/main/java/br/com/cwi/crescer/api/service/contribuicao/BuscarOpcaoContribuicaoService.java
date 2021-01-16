package br.com.cwi.crescer.api.service.contribuicao;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.repository.DesafioOpcaoContribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class BuscarOpcaoContribuicaoService {

    @Autowired
    DesafioOpcaoContribuicaoRepository repository;

    public DesafioOpcaoContribuicao buscar(Desafio desafio, String contribuicao){

        Optional<DesafioOpcaoContribuicao> opcao = repository.findByDesafioAndContribuicao(desafio, contribuicao);

        if(!opcao.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contribuição selecionada é inválida.");

        return opcao.get();
    }
}
