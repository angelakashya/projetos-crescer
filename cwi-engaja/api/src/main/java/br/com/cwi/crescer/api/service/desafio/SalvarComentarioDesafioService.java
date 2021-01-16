package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.responsedto.DesafioComentarioResponse;
import br.com.cwi.crescer.api.domain.DesafioComentario;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.mapper.desafio.DesafioComentarioResponseMapper;
import br.com.cwi.crescer.api.repository.DesafioComentarioRepository;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SalvarComentarioDesafioService {

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    private DesafioComentarioRepository desafioComentarioRepository;

    @Autowired
    private DesafioComentarioResponseMapper desafioComentarioResponseMapper;

    public DesafioComentarioResponse salvar(DesafioComentario comentario) {
        Usuario usuario = buscarUsuarioAutenticadoService.buscar();
        comentario.setUsuario(usuario);
        comentario.setDataCadastro(LocalDate.now());
        desafioComentarioRepository.save(comentario);
        return desafioComentarioResponseMapper.apply(comentario);
    }
}
