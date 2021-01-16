package br.com.cwi.crescer.api.service.prestacaodecontas;

import br.com.cwi.crescer.api.controller.requestdto.PrestacaoDeContasRequest;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioMeta;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.DesafioMetaRepository;
import br.com.cwi.crescer.api.service.desafio.BuscarDesafioPorIdService;
import br.com.cwi.crescer.api.service.meta.BuscarMetaPorIdService;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import br.com.cwi.crescer.api.validator.desafio.CriadorDesafioValidator;
import br.com.cwi.crescer.api.validator.desafio.DesafioEncerradoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PrestarContasService {

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticado;

    @Autowired
    private BuscarDesafioPorIdService buscarDesafio;

    @Autowired
    private CriadorDesafioValidator criadorDesafioValidator;

    @Autowired
    private DesafioEncerradoValidator desafioEncerradoValidator;

    @Autowired
    private BuscarMetaPorIdService buscarMeta;

    @Autowired
    private DesafioMetaRepository repository;

    public DesafioMeta prestar(PrestacaoDeContasRequest request, Integer idDesafio) {
        Usuario usuario = buscarUsuarioAutenticado.buscar();
        Desafio desafio = buscarDesafio.buscar(idDesafio);

        criadorDesafioValidator.validar(desafio, usuario);

        desafioEncerradoValidator.validar(desafio);

        DesafioMeta meta = buscarMeta.buscar(request.getIdMeta());

        if(request.getFoto() == null && request.getDescricao() ==  null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "É necessário informar a descrição e/ou a imagem para prestar contas.");

        if(request.getFoto() != null)
            meta.setImagemPrestacao(request.getFoto());
        if(request.getDescricao() != null)
            meta.setDescricaoPrestacao(request.getDescricao());

        repository.save(meta);

        return meta;
    }
}
