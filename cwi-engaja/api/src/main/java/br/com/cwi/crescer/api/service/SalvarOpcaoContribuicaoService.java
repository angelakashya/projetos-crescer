package br.com.cwi.crescer.api.service;

import br.com.cwi.crescer.api.controller.requestdto.DesafioRequest;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.repository.DesafioOpcaoContribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalvarOpcaoContribuicaoService {

    @Autowired
    private DesafioOpcaoContribuicaoRepository desafioOpcaoContribuicaoRepository;

    public List<DesafioOpcaoContribuicao> salvar(DesafioRequest desafioRequest, Desafio desafio) {
        List<DesafioOpcaoContribuicao> listaOpcaoContribuicao = new ArrayList<>();
        if (desafioRequest.getDesafioOpcaoContribuicao() != null) {
            for (DesafioOpcaoContribuicao opcaoContribuicao : desafioRequest.getDesafioOpcaoContribuicao()) {
                opcaoContribuicao.setDesafio(desafio);
                desafioOpcaoContribuicaoRepository.save(opcaoContribuicao);
                listaOpcaoContribuicao.add(opcaoContribuicao);
            }
        }
        return listaOpcaoContribuicao;
    }
}
