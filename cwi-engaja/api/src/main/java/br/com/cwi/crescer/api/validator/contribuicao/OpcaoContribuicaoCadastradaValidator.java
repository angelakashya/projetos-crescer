package br.com.cwi.crescer.api.validator.contribuicao;

import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import org.springframework.stereotype.Component;

@Component
public class OpcaoContribuicaoCadastradaValidator {

    public boolean validar(DesafioOpcaoContribuicao contribuicao){

        return !contribuicao.getContribuicao().equals("");
    }
}
