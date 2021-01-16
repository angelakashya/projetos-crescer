package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.responsedto.ListarDesafiosResponse;
import br.com.cwi.crescer.api.domain.*;
import br.com.cwi.crescer.api.mapper.desafio.ListaDesafioResponseMapper;
import br.com.cwi.crescer.api.repository.CurtidaRepository;
import br.com.cwi.crescer.api.repository.DesafioComentarioRepository;
import br.com.cwi.crescer.api.repository.DesafioMetaRepository;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioService;
import br.com.cwi.crescer.api.service.usuario.VerificarSeUsuarioJaContribuiuService;
import br.com.cwi.crescer.api.validator.desafio.DesafioDaEquipeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListarDesafiosService {

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    private DesafioRepository desafioRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private DesafioMetaRepository desafioMetaRepository;

    @Autowired
    private VerificarSeUsuarioJaContribuiuService verificarSeUsuarioJaContribuiuService;

    @Autowired
    private ListaDesafioResponseMapper modelMapper;

    @Autowired
    private VerificarDesafioValidoService verificarDesafioValidoService;

    @Autowired
    private VerificarDesafioChegandoAoFim verificarDesafioChegandoAoFim;

    @Autowired
    private DesafioDaEquipeValidator desafioDaEquipeValidator;

    @Autowired
    private DesafioComentarioRepository desafioComentarioRepository;

    @Autowired
    private CurtidaRepository curtidaRepository;

    @Autowired
    private VerificarSeUsuarioJaCurtiuService verificarCurtida;

    public List<ListarDesafiosResponse> listar() {
        List<Desafio> desafios= new ArrayList<>();

        Usuario usuario = buscarUsuarioAutenticadoService.buscar();

        Optional<List<Desafio>> listaDesafios = desafioRepository.findByUsuario(usuario);

        if (listaDesafios.isPresent()) {
            desafios.addAll(listaDesafios.get());
        }

        if (!usuario.getGestor().equalsIgnoreCase(Socios.JAMES.toString()) &&
                !usuario.getGestor().equalsIgnoreCase(Socios.TESSER.toString())) {
            Usuario gestor = buscarUsuarioService.buscar(usuario.getGestor());
            Optional<List<Desafio>> listaDesafiosEquipe = desafioRepository.findByTipoDesafioAndUsuario(TipoDesafio.EQUIPE, gestor);
            if (listaDesafiosEquipe.isPresent()) {
                desafios.addAll(listaDesafiosEquipe.get());
            }
        }

        Optional<List<Desafio>> listaDesafiosGlobal = desafioRepository.findByTipoDesafioAndUsuarioNot(TipoDesafio.GLOBAL, usuario);
        if (listaDesafiosGlobal.isPresent()) {
            desafios.addAll(listaDesafiosGlobal.get());
        }

        for (Desafio desafio : desafios) {

            Long quantidadeDeCurtidas = curtidaRepository.countByDesafio(desafio);
            Long quantidadeDeComentarios = desafioComentarioRepository.countByDesafio(desafio);

            desafio.setIsAtivo(verificarDesafioValidoService.isAtivo(desafio));
            desafio.setIsChegandoAoFim(verificarDesafioChegandoAoFim.isChegandoAoFim(desafio));
            desafio.setJaContribuiu( verificarSeUsuarioJaContribuiuService.jaContribuiu(desafio, usuario));
            desafio.setIsEquipe(desafioDaEquipeValidator.validar(desafio));
            desafio.setCurtiu(verificarCurtida.verificar(desafio, usuario));
            desafio.setQuantidadeDeCurtidas(quantidadeDeCurtidas);
            desafio.setQuantidadeDeComentarios(quantidadeDeComentarios);

            Optional<List<DesafioMeta>> metas = desafioMetaRepository.findByDesafio(desafio);
            if (metas.isPresent()) {
                desafio.setMetas(metas.get());
            }

        }

        return desafios
                .stream()
                .map(desafio -> modelMapper.apply(desafio))
                .collect(Collectors.toList());

    }

}
