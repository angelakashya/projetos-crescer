package br.com.cwi.crescer.api.mapper;

import br.com.cwi.crescer.api.controller.responsedto.PerfilUsuarioResponse;
import br.com.cwi.crescer.api.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class PerfilUsuarioResponseMapper {

    public PerfilUsuarioResponse apply(Usuario usuario, String nomeGestor) {
        PerfilUsuarioResponse response = new PerfilUsuarioResponse();
        response.setNomeGestor(nomeGestor);
        response.setNome(usuario.getNome());

        return response;
    }
}
