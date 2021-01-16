package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.domain.TipoCargo;
import br.com.cwi.crescer.api.domain.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioGlobalValidator {

    public boolean validar(Usuario usuario) {
        List<TipoCargo> globais = new ArrayList<>();
        globais.add(TipoCargo.ADM);
        globais.add(TipoCargo.RH);
        globais.add(TipoCargo.DIRETOR);

        return globais.contains(usuario.getCargo());
    }
}
