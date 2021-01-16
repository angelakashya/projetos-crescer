package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.controller.responsedto.ListarDetalhesDesafioResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.mapper.desafio.ListarDetalhesDesafioResponseMapper;
import br.com.cwi.crescer.api.repository.CurtidaRepository;
import br.com.cwi.crescer.api.repository.DesafioComentarioRepository;
import br.com.cwi.crescer.api.service.contribuicao.BuscarOpcoesDeContribuicaoPreDefinidasService;
import br.com.cwi.crescer.api.service.meta.BuscarMetasDoDesafioService;
import br.com.cwi.crescer.api.service.usuario.VerificarSeUsuarioJaContribuiuService;
import br.com.cwi.crescer.api.validator.desafio.DesafioAtivoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GerarDetalhesService {

    @Autowired
    private DesafioComentarioRepository desafioComentarioRepository;

    @Autowired
    private CurtidaRepository curtidaRepository;

    @Autowired
    private VerificarSeUsuarioJaContribuiuService verificarSeUsuarioJaContribuiuService;

    @Autowired
    private BuscarOpcoesDeContribuicaoPreDefinidasService buscarOpcoesContribuicao;

    @Autowired
    private BuscarMetasDoDesafioService buscarMetas;

    @Autowired
    private ListarDetalhesDesafioResponseMapper listarDetalhesDesafioResponseMapper;

    @Autowired
    private DesafioAtivoValidator validarAtivo;

    @Autowired
    private VerificarPrestacaoDeContasService verificarPrestacaoDeContas;

    @Autowired
    private VerificarSeUsuarioJaCurtiuService verificarCurtida;

    public ListarDetalhesDesafioResponse gerar(Desafio desafio, Usuario usuario) {

        Long quantidadeDeCurtidas = curtidaRepository.countByDesafio(desafio);
        Long quantidadeDeComentarios = desafioComentarioRepository.countByDesafio(desafio);

        desafio.setJaContribuiu(verificarSeUsuarioJaContribuiuService.jaContribuiu(desafio, usuario));
        desafio.setOpcaoContribuicao(buscarOpcoesContribuicao.buscar(desafio));
        desafio.setMetas(buscarMetas.buscar(desafio));
        desafio.setQuantidadeDeComentarios(quantidadeDeComentarios);
        desafio.setQuantidadeDeCurtidas(quantidadeDeCurtidas);
        desafio.setCurtiu(verificarCurtida.verificar(desafio, usuario));

        verificarPrestacaoDeContas.verificar(desafio);

        try{
            validarAtivo.validar(desafio);
            desafio.setIsAtivo(true);
        }catch(ResponseStatusException e){
            desafio.setIsAtivo(false);
        }

        return listarDetalhesDesafioResponseMapper.apply(desafio);
    }
}
