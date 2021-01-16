package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import br.com.cwi.crescer.api.service.usuario.VerificarUsuarioParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarCurtidaService {

    @Autowired
    BuscarUsuarioAutenticadoService buscarUsuario;

    @Autowired
    private BuscarDesafioPorIdService buscarDesafio;

    @Autowired
    private VerificarUsuarioParticipanteService verificarParticipante;

    @Autowired
    private VerificarSeUsuarioJaCurtiuService verificarSeJaCurtiu;

    @Autowired
    private DescurtirDesafioService descurtirService;

    @Autowired
    private CurtirDesafioService curtirService;

    public void atualizar(Integer idDesafio) {
        Usuario usuario = buscarUsuario.buscar();
        Desafio desafio = buscarDesafio.buscar(idDesafio);

        verificarParticipante.verificar(desafio);

        if(verificarSeJaCurtiu.verificar(desafio, usuario))
            descurtirService.descurtir(desafio, usuario);
        else
            curtirService.curtir(desafio, usuario);
    }
}
