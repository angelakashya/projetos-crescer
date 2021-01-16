package br.com.cwi.crescer.api.validator.contribuicao;

import br.com.cwi.crescer.api.controller.requestdto.DesafioRequest;
import org.springframework.stereotype.Component;

@Component
public class ListaOpcaoContribuicaoValidator {

    public boolean validar(DesafioRequest request) {
        if(request.getDesafioOpcaoContribuicao() == null)
            return false;
        if(request.getDesafioOpcaoContribuicao().isEmpty())
            return false;

        return request.getDesafioOpcaoContribuicao().size() != 1 ||
                !request.getDesafioOpcaoContribuicao().get(0).getContribuicao().equals("");
    }
}
