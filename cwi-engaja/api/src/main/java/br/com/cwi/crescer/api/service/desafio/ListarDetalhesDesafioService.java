package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.responsedto.ListarDetalhesDesafioResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Socios;
import br.com.cwi.crescer.api.domain.TipoDesafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.mapper.desafio.ListarDetalhesDesafioResponseMapper;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioService;
import br.com.cwi.crescer.api.service.usuario.VerificarSeUsuarioJaContribuiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ListarDetalhesDesafioService {

    @Autowired
    private VerificarDesafioValidoService verificarDesafioValidoService;

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    private DesafioRepository desafioRepository;

    @Autowired
    private ListarDetalhesDesafioResponseMapper listarDetalhesDesafioResponseMapper;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private VerificarSeUsuarioJaContribuiuService verificarSeUsuarioJaContribuiuService;

    @Autowired
    private GerarDetalhesService gerarDetalhes;

    public ListarDetalhesDesafioResponse listarDesafioDetalhe(Integer id) {
        Usuario usuario = buscarUsuarioAutenticadoService.buscar();

        Optional<Desafio> desafioGlobal = desafioRepository.findByIdAndTipoDesafio(id, TipoDesafio.GLOBAL);
        if (desafioGlobal.isPresent()) {
            Desafio desafio = desafioGlobal.get();
            if(usuario.getUser().equals(desafio.getUsuario().getUser()))
                desafio.setIsCriador(true);
            desafio.setIsGlobal(true);
            return gerarDetalhes.gerar(desafio, usuario);
        }

        if (!usuario.getGestor().equalsIgnoreCase(Socios.JAMES.toString()) &&
                !usuario.getGestor().equalsIgnoreCase(Socios.TESSER.toString())) {
            Usuario gestor = buscarUsuarioService.buscar(usuario.getGestor());
            Optional<Desafio> desafioGestor = desafioRepository.findByIdAndUsuario(id, gestor);
            if (desafioGestor.isPresent()) {
                Desafio desafio = desafioGestor.get();
                desafio.setIsEquipe(true);
                return gerarDetalhes.gerar(desafio, usuario);
            }
        }

        Optional<Desafio> meuDesafio = desafioRepository.findByIdAndUsuario(id, usuario);
        if (meuDesafio.isPresent()) {
            Desafio desafio = meuDesafio.get();
            desafio.setIsCriador(true);
            if (TipoDesafio.GLOBAL.equals(meuDesafio.get().getTipoDesafio())) {
                meuDesafio.get().setIsGlobal(true);
            } else {
                meuDesafio.get().setIsEquipe(true);
            }
            return gerarDetalhes.gerar(desafio, usuario);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não encontramos desafios para você.");
    }

}
