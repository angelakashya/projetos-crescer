package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.domain.Curtida;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class NovaCurtidaMapper {

    public Curtida apply(Curtida curtida, Usuario usuario, Desafio desafio) {
        curtida.setDesafio(desafio);
        curtida.setUsuario(usuario);
        return curtida;
    }
}
