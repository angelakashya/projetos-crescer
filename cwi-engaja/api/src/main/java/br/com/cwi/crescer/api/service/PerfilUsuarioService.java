package br.com.cwi.crescer.api.service;

import br.com.cwi.crescer.api.controller.responsedto.PerfilUsuarioResponse;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.mapper.PerfilUsuarioResponseMapper;
import br.com.cwi.crescer.api.security.UsuarioAutenticado;
import br.com.cwi.crescer.api.validator.UsuarioGlobalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PerfilUsuarioService {

    @Autowired
    BuscarUsuarioService buscarUsuario;

    @Autowired
    BuscarNomeGestorService buscarGestor;

    @Autowired
    PerfilUsuarioResponseMapper perfilMapper;

    @Autowired
    UsuarioGlobalValidator globalValidator;

    @Autowired
    BuscarEquipeDoUsuarioService equipeService;

    public PerfilUsuarioResponse buscar() {
        UsuarioAutenticado autenticado =
                (UsuarioAutenticado) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Usuario usuario = buscarUsuario.buscar(autenticado.getUsuario());
        String nomeGestor = buscarGestor.buscar(usuario);

        PerfilUsuarioResponse response = perfilMapper.apply(usuario, nomeGestor);
        response.setIsGlobal(globalValidator.validar(usuario));
        response.setIsGestor(!equipeService.buscar(usuario).isEmpty());
        response.setPosicao(usuario.getPosicao());

        return response;
    }
}
