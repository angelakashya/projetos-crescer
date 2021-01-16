package br.com.cwi.crescer.api.service.contribuicao;

import br.com.cwi.crescer.api.controller.requestdto.NovaContribuicaoRequest;
import br.com.cwi.crescer.api.controller.responsedto.NovaContribuicaoResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.mapper.contribuicao.NovaContribuicaoMapper;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import br.com.cwi.crescer.api.repository.DesafioUsuarioContribuicaoRepository;
import br.com.cwi.crescer.api.service.desafio.BuscarDesafioPorIdService;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import br.com.cwi.crescer.api.service.usuario.VerificarUsuarioParticipanteService;
import br.com.cwi.crescer.api.validator.desafio.DataLimiteDesafioValidator;
import br.com.cwi.crescer.api.validator.desafio.DesafioAtivoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContribuirComDesafioService {

    static final int CONTRIBUICAO = 1;

    @Autowired
    BuscarUsuarioAutenticadoService buscarAutenticado;

    @Autowired
    BuscarDesafioPorIdService buscarDesafio;

    @Autowired
    VerificarContribuicaoUsuarioService verificarNovaContribuicao;

    @Autowired
    VerificarUsuarioParticipanteService verificarParticipante;

    @Autowired
    DesafioAtivoValidator desafioAtivoValidator;

    @Autowired
    DataLimiteDesafioValidator dataLimiteValidator;

    @Autowired
    BuscarOpcaoContribuicaoService buscarContribuicao;

    @Autowired
    NovaContribuicaoMapper contribuicaoMapper;

    @Autowired
    DesafioUsuarioContribuicaoRepository contribuicaoUsuarioRepository;

    @Autowired
    DesafioRepository desafioRepository;

    public NovaContribuicaoResponse contribuir(NovaContribuicaoRequest request) {

        Usuario usuario = buscarAutenticado.buscar();

        Desafio desafio = buscarDesafio.buscar(request.getIdDesafio());

        desafioAtivoValidator.validar(desafio);

        dataLimiteValidator.validar(desafio);

        verificarParticipante.verificar(desafio);

        verificarNovaContribuicao.verificar(desafio, usuario);

        DesafioOpcaoContribuicao opcaoContribuicao;

        opcaoContribuicao = buscarContribuicao.buscar(desafio, request.getContribuicao());

        DesafioUsuarioContribuicao contribuicaoUsuario = contribuicaoMapper.apply(desafio, usuario, opcaoContribuicao);

        desafio.setQuantidadeParticipantes(desafio.getQuantidadeParticipantes() + CONTRIBUICAO);

        contribuicaoUsuarioRepository.save(contribuicaoUsuario);

        desafioRepository.save(desafio);

        NovaContribuicaoResponse response = new NovaContribuicaoResponse();
        response.setContribuicoes(desafio.getQuantidadeParticipantes());

        return response;
    }

}
