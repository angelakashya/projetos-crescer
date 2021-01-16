package br.com.cwi.crescer.api.service.contribuicao;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.repository.DesafioOpcaoContribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalvarOpcaoPadraoService {

    @Autowired
    private DesafioOpcaoContribuicaoRepository desafioOpcaoContribuicaoRepository;

    public DesafioOpcaoContribuicao salvar(Desafio desafio) {
        DesafioOpcaoContribuicao contribuicaoPadrao = new DesafioOpcaoContribuicao();
        contribuicaoPadrao.setDesafio(desafio);
        contribuicaoPadrao.setContribuicao(DesafioOpcaoContribuicao.CONTRIBUICAO_PADRAO);
        desafioOpcaoContribuicaoRepository.save(contribuicaoPadrao);

        return contribuicaoPadrao;
    }

}
