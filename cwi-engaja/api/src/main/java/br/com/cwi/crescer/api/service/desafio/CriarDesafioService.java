package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.requestdto.DesafioRequest;
import br.com.cwi.crescer.api.controller.responsedto.DesafioResponse;
import br.com.cwi.crescer.api.domain.*;
import br.com.cwi.crescer.api.mapper.desafio.DesafioRequestMapper;
import br.com.cwi.crescer.api.mapper.desafio.DesafioResponseMapper;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import br.com.cwi.crescer.api.repository.UsuarioRepository;
import br.com.cwi.crescer.api.service.contribuicao.SalvarOpcaoContribuicaoService;
import br.com.cwi.crescer.api.service.meta.FiltrarMetasValidasService;
import br.com.cwi.crescer.api.service.meta.SalvarMetaService;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import br.com.cwi.crescer.api.service.usuario.PerfilUsuarioService;
import br.com.cwi.crescer.api.validator.desafio.DataLimiteCriacaoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CriarDesafioService {

    @Autowired
    private VerificarPermissaoTipoUsuarioDesafioService verificarPermissaoTipoUsuarioDesafioService;

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

    @Autowired
    DataLimiteCriacaoValidator dataLimiteValidator;

    @Autowired
    FiltrarMetasValidasService filtrarMetasValidasService;

    @Transactional
    public DesafioResponse criar(DesafioRequest desafioRequest) {

        Desafio desafio = requestMapper.apply(desafioRequest);
        Usuario usuario = buscarUsuarioAutenticadoService.buscar();

        desafio.setUsuario(usuario);

        verificarPermissaoTipoUsuarioDesafioService.validar(desafio);

        dataLimiteValidator.validar(desafio);

        if(desafio.getTipoDesafio().equals(TipoDesafio.GLOBAL))
            desafio.setMaxParticipantes(usuarioRepository.count());
        else
            desafio.setMaxParticipantes(usuarioRepository.countByGestor(usuario.getUser())
                    + PerfilUsuarioService.PROPRIO_USUARIO);

        List<DesafioMeta> listaDeMetas = filtrarMetasValidasService.filtrar(desafioRequest, desafio.getMaxParticipantes());

        if(listaDeMetas.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pelo menos uma meta válida deve ser informada.");

        desafio.setStatus(Status.ATIVO);
        desafio = desafioRepository.save(desafio);

        salvarMetaService.salvar(listaDeMetas, desafio);
        List<DesafioOpcaoContribuicao> listaOpcaoContribuicao = salvarOpcaoContribuicaoService.salvar(desafioRequest, desafio);

        desafio.setMetas(listaDeMetas);
        desafio.setOpcaoContribuicao(listaOpcaoContribuicao);

        return responseMapper.apply(desafio);
    }
}
