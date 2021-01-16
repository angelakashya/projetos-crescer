package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.requestdto.DesafioComentarioRequest;
import br.com.cwi.crescer.api.controller.responsedto.DesafioComentarioResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioComentario;
import br.com.cwi.crescer.api.mapper.desafio.DesafioComentarioRequestMapper;
import br.com.cwi.crescer.api.service.usuario.VerificarUsuarioParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarDesafioService {

    @Autowired
    private BuscarDesafioPorIdService buscarDesafioPorIdService;

    @Autowired
    private VerificarUsuarioParticipanteService verificarUsuarioParticipanteService;

    @Autowired
    private SalvarComentarioDesafioService salvarComentarioDesafioService;

    @Autowired
    private DesafioComentarioRequestMapper requestMapper;

    public DesafioComentarioResponse comentar(Integer idDesafio, DesafioComentarioRequest desafioComentarioRequest) {

        Desafio desafio = buscarDesafioPorIdService.buscar(idDesafio);
        verificarUsuarioParticipanteService.verificar(desafio);

        DesafioComentario comentario = requestMapper.apply(desafioComentarioRequest);
        comentario.setDesafio(desafio);

        return salvarComentarioDesafioService.salvar(comentario);
    }
}
