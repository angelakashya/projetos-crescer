package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.responsedto.ResultadoDesafioResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import br.com.cwi.crescer.api.mapper.desafio.ResultadoDesafioComOpcaoResponseMapper;
import br.com.cwi.crescer.api.mapper.desafio.ResultadoDesafioSemOpcaoMapper;
import br.com.cwi.crescer.api.service.contribuicao.BuscarContribuicoesDoDesafioService;
import br.com.cwi.crescer.api.service.contribuicao.BuscarOpcoesDeContribuicaoPreDefinidasService;
import br.com.cwi.crescer.api.validator.desafio.DesafioEncerradoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarResultadosDesafioService {

    @Autowired
    private BuscarDesafioPorIdService buscarDesafio;

    @Autowired
    private DesafioEncerradoValidator validarEncerrado;

    @Autowired
    private BuscarOpcoesDeContribuicaoPreDefinidasService buscarOpcoes;

    @Autowired
    private BuscarContribuicoesDoDesafioService buscarContribuicoes;

    @Autowired
    private ResultadoDesafioSemOpcaoMapper resultadoSemOpcaoMapper;

    @Autowired
    private ResultadoDesafioComOpcaoResponseMapper resultadoComOpcaoMapper;

    public List<ResultadoDesafioResponse> listar(Integer idDesafio) {

        Desafio desafio = buscarDesafio.buscar(idDesafio);

        validarEncerrado.validar(desafio);

        List<DesafioUsuarioContribuicao> contribuicoes = buscarContribuicoes.buscar(desafio);

        List<DesafioOpcaoContribuicao> opcoes = buscarOpcoes.buscar(desafio);


        if(opcoes.isEmpty()){
            return contribuicoes
                    .stream()
                    .map(c -> resultadoSemOpcaoMapper.apply(c))
                    .collect(Collectors.toList());
        }

        return contribuicoes
                .stream()
                .map(c -> resultadoComOpcaoMapper.apply(c)).
                collect(Collectors.toList());
    }
}
