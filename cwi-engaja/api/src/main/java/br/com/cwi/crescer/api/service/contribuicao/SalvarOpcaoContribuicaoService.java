package br.com.cwi.crescer.api.service.contribuicao;

import br.com.cwi.crescer.api.controller.requestdto.DesafioRequest;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.repository.DesafioOpcaoContribuicaoRepository;
import br.com.cwi.crescer.api.validator.contribuicao.ListaOpcaoContribuicaoValidator;
import br.com.cwi.crescer.api.validator.contribuicao.OpcaoContribuicaoCadastradaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalvarOpcaoContribuicaoService {

    @Autowired
    private DesafioOpcaoContribuicaoRepository desafioOpcaoContribuicaoRepository;

    @Autowired
    private OpcaoContribuicaoCadastradaValidator opcaoValidator;

    @Autowired
    private ListaOpcaoContribuicaoValidator listaPreenchidaValidator;

    @Autowired
    SalvarOpcaoPadraoService salvarOpcaoPadrao;

    public List<DesafioOpcaoContribuicao> salvar(DesafioRequest desafioRequest, Desafio desafio) {
        List<DesafioOpcaoContribuicao> listaOpcaoContribuicao = new ArrayList<>();

        if (listaPreenchidaValidator.validar(desafioRequest)) {
            for (DesafioOpcaoContribuicao opcaoContribuicao : desafioRequest.getDesafioOpcaoContribuicao()) {
                if(opcaoValidator.validar(opcaoContribuicao)){
                    opcaoContribuicao.setDesafio(desafio);
                    desafioOpcaoContribuicaoRepository.save(opcaoContribuicao);
                    listaOpcaoContribuicao.add(opcaoContribuicao);
                }
            }
        } else{
            salvarOpcaoPadrao.salvar(desafio);
        }

        return listaOpcaoContribuicao;
    }
}