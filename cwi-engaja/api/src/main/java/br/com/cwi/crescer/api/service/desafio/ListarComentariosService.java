package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.responsedto.DesafioComentarioResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioComentario;
import br.com.cwi.crescer.api.mapper.desafio.DesafioComentarioResponseMapper;
import br.com.cwi.crescer.api.repository.DesafioComentarioRepository;
import br.com.cwi.crescer.api.service.usuario.VerificarUsuarioParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListarComentariosService {

    @Autowired
    private VerificarUsuarioParticipanteService verificarUsuarioParticipanteService;

    @Autowired
    private BuscarDesafioPorIdService buscarDesafioPorIdService;

    @Autowired
    private DesafioComentarioRepository desafioComentarioRepository;

    @Autowired
    private DesafioComentarioResponseMapper desafioComentarioResponseMapper;

    public List<DesafioComentarioResponse> listar(Integer idDesafio) {

        Desafio desafio = buscarDesafioPorIdService.buscar(idDesafio);
        verificarUsuarioParticipanteService.verificar(desafio);

        Optional<List<DesafioComentario>> comentariosOptional = desafioComentarioRepository.findByDesafio(desafio);

        return comentariosOptional.orElseGet(ArrayList::new)
                .stream()
                .map(comentario -> desafioComentarioResponseMapper.apply(comentario))
                .collect(Collectors.toList());

    }
}
