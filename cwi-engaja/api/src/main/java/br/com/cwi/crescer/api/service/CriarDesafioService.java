package br.com.cwi.crescer.api.service;

import br.com.cwi.crescer.api.controller.requestdto.DesafioRequest;
import br.com.cwi.crescer.api.controller.responsedto.DesafioResponse;
import br.com.cwi.crescer.api.domain.*;
import br.com.cwi.crescer.api.mapper.DesafioRequestMapper;
import br.com.cwi.crescer.api.mapper.DesafioResponseMapper;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import br.com.cwi.crescer.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CriarDesafioService {

    @Autowired
    private ValidarPermissaoTipoUsuarioDesafioService validarPermissaoTipoUsuarioDesafioService;

    @Autowired
    private DesafioRequestMapper requestMapper;

    @Autowired
    private DesafioRepository desafioRepository;

    @Autowired
    private SalvarMetaService salvarMetaService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SalvarOpcaoContribuicaoService salvarOpcaoContribuicaoService;

    @Autowired
    private DesafioResponseMapper responseMapper;

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Transactional
    public DesafioResponse criar(DesafioRequest desafioRequest) {

        Desafio desafio = requestMapper.apply(desafioRequest);
        Usuario usuario = buscarUsuarioAutenticadoService.buscar();
        desafio.setUsuario(usuario);

        validarPermissaoTipoUsuarioDesafioService.validar(desafio);

        desafio.setStatus(Status.ATIVO);
        desafio = desafioRepository.save(desafio);

        List<DesafioMeta> listaMeta = salvarMetaService.salvar(desafioRequest, desafio);
        List<DesafioOpcaoContribuicao> listaOpcaoContribuicao = salvarOpcaoContribuicaoService.salvar(desafioRequest, desafio);

        desafio.setMeta(listaMeta);
        desafio.setOpcaoContribuicao(listaOpcaoContribuicao);

        return responseMapper.apply(desafio);
    }
}
