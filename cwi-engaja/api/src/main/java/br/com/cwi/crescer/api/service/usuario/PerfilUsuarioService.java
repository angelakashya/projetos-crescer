package br.com.cwi.crescer.api.service.usuario;

import br.com.cwi.crescer.api.controller.responsedto.PerfilUsuarioResponse;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.mapper.usuario.PerfilUsuarioResponseMapper;
import br.com.cwi.crescer.api.repository.UsuarioRepository;
import br.com.cwi.crescer.api.validator.usuario.UsuarioGlobalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilUsuarioService {

    public static final Long PROPRIO_USUARIO = 1L;

    @Autowired
    BuscarUsuarioAutenticadoService buscarUsuarioAutenticado;

    @Autowired
    BuscarNomeGestorService buscarGestor;

    @Autowired
    PerfilUsuarioResponseMapper perfilMapper;

    @Autowired
    UsuarioGlobalValidator globalValidator;

    @Autowired
    BuscarEquipeDoUsuarioService equipeService;

    @Autowired
    UsuarioRepository usuarioRepository;

    public PerfilUsuarioResponse buscar() {

        Usuario usuario = buscarUsuarioAutenticado.buscar();
        String nomeGestor = buscarGestor.buscar(usuario);

        PerfilUsuarioResponse response = perfilMapper.apply(usuario, nomeGestor);
        response.setIsGlobal(globalValidator.validar(usuario));
        response.setIsGestor(!equipeService.buscar(usuario).isEmpty());
        response.setPosicao(usuario.getPosicao());

        if(response.getIsGlobal())
            response.setTamanhoCwi(usuarioRepository.count());
        if(response.getIsGestor())
            response.setTamanhoEquipe(usuarioRepository.countByGestor(usuario.getUser()) + PROPRIO_USUARIO);

        return response;
    }
}
