package br.com.cwi.crescer.api.service.contribuicao;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.repository.DesafioOpcaoContribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuscarOpcoesDeContribuicaoPreDefinidasService {

    @Autowired
    private DesafioOpcaoContribuicaoRepository repository;

    public List<DesafioOpcaoContribuicao> buscar(Desafio desafio) {

        Optional<List<DesafioOpcaoContribuicao>> busca = repository
                .findByDesafioAndContribuicaoNot(desafio, DesafioOpcaoContribuicao.CONTRIBUICAO_PADRAO);

        return busca.orElseGet(ArrayList::new);

    }
}
