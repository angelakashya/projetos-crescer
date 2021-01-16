package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.TipoCargo;
import br.com.cwi.crescer.api.domain.TipoDesafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.service.usuario.BuscarEquipeDoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VerificarPermissaoTipoUsuarioDesafioService {

    @Autowired
    private BuscarEquipeDoUsuarioService buscarEquipeService;

    public void validar(Desafio desafio) {
        if (TipoCargo.COLABORADOR.equals(desafio.getUsuario().getCargo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não possui permissão para criar desafio.");
        } else if ( (TipoCargo.GERENTE.equals(desafio.getUsuario().getCargo())
                || TipoCargo.GESTOR.equals(desafio.getUsuario().getCargo())) && TipoDesafio.GLOBAL.equals(desafio.getTipoDesafio())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não possui permissão para criar desafio global.");
        } else if (TipoDesafio.EQUIPE.equals(desafio.getTipoDesafio())) {
            List<Usuario> usuarios = buscarEquipeService.buscar(desafio.getUsuario());
            if (usuarios.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não pode criar desafio para equipe, pois, o mesmo não possui equipe.");
            }
        }
    }
}
