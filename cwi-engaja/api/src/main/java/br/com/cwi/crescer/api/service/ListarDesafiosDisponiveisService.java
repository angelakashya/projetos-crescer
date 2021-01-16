package br.com.cwi.crescer.api.service;

import br.com.cwi.crescer.api.controller.requestdto.DesafioRequest;
import br.com.cwi.crescer.api.domain.*;
import br.com.cwi.crescer.api.repository.DesafioMetaRepository;
import br.com.cwi.crescer.api.repository.DesafioOpcaoContribuicaoRepository;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListarDesafiosDisponiveisService {

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    private DesafioRepository desafioRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private DesafioMetaRepository desafioMetaRepository;

    @Autowired
    private DesafioOpcaoContribuicaoRepository desafioOpcaoContribuicaoRepository;

    public List<Desafio> listar() {
        List<Desafio> desafios = new ArrayList<>();
        Usuario usuario = buscarUsuarioAutenticadoService.buscar();

        if (!usuario.getGestor().equals(Socios.JAMES.toString().toLowerCase())
            && !usuario.getGestor().equals(Socios.TESSER.toString().toLowerCase())) {
            Usuario gestor = buscarUsuarioService.buscar(usuario.getGestor());
            Optional<List<Desafio>> listaDesafiosEquipe = desafioRepository.findByTipoDesafioAndUsuario(TipoDesafio.EQUIPE, gestor);
            if (listaDesafiosEquipe.isPresent()) {
                desafios.addAll(listaDesafiosEquipe.get());
            }
        }

        Optional<List<Desafio>> listaDesafiosGlobal = desafioRepository.findByTipoDesafio(TipoDesafio.GLOBAL);
        if (listaDesafiosGlobal.isPresent()) {
            desafios.addAll(listaDesafiosGlobal.get());
        }
        for (Desafio desafio : desafios) {
            Optional<List<DesafioMeta>> metas = desafioMetaRepository.findByDesafio(desafio);
            if (metas.isPresent()) {
                desafio.setMeta(metas.get());
            }
            Optional<List<DesafioOpcaoContribuicao>> contribuicoes = desafioOpcaoContribuicaoRepository.findByDesafio(desafio);
            if (contribuicoes.isPresent()) {
                desafio.setOpcaoContribuicao(contribuicoes.get());
            }

        }
        return desafios;
    }

}
