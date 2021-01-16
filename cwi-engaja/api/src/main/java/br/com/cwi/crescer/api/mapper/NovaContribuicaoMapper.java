package br.com.cwi.crescer.api.mapper;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import br.com.cwi.crescer.api.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class NovaContribuicaoMapper {

    public DesafioUsuarioContribuicao apply(Desafio desafio, Usuario usuario, DesafioOpcaoContribuicao contribuicao) {
        DesafioUsuarioContribuicao response = new DesafioUsuarioContribuicao();
        response.setDesafio(desafio);
        response.setUsuario(usuario);
        response.setDesafioOpcaoContribuicao(contribuicao);

        return response;
    }
}
