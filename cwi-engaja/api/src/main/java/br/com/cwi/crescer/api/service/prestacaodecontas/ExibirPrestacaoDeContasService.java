package br.com.cwi.crescer.api.service.prestacaodecontas;

import br.com.cwi.crescer.api.controller.responsedto.PrestacaoDeContasResponse;
import br.com.cwi.crescer.api.domain.DesafioMeta;
import br.com.cwi.crescer.api.mapper.prestacaodecontas.PrestacaoDecontasResponseMapper;
import br.com.cwi.crescer.api.service.desafio.PermissaoVisualizacaoService;
import br.com.cwi.crescer.api.service.meta.BuscarMetaPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ExibirPrestacaoDeContasService {

    @Autowired
    private BuscarMetaPorIdService buscarMetaPorIdService;

    @Autowired
    private PermissaoVisualizacaoService permissaoVisualizacaoService;

    @Autowired
    private PrestacaoDecontasResponseMapper responseMapper;


    public PrestacaoDeContasResponse exibir(Integer idDesafioMeta) {

        DesafioMeta meta = buscarMetaPorIdService.buscar(idDesafioMeta);

        if (meta.getImagemPrestacao() == null && meta.getDescricaoPrestacao() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A meta não possuí prestação de contas.");
        }

        permissaoVisualizacaoService.validar(meta.getDesafio());

        return responseMapper.apply(meta);
    }

}
