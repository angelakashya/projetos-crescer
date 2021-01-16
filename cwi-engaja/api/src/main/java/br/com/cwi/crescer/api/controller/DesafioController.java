package br.com.cwi.crescer.api.controller;

import br.com.cwi.crescer.api.controller.requestdto.DesafioRequest;
import br.com.cwi.crescer.api.controller.requestdto.NovaContribuicaoRequest;
import br.com.cwi.crescer.api.controller.responsedto.DesafioResponse;
import br.com.cwi.crescer.api.controller.responsedto.NovaContribuicaoResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("private/desafio")
public class DesafioController {

    @Autowired
    private CriarDesafioService criarDesafioService;

    @Autowired
    private ContribuirComDesafioService contribuirService;

    @Autowired
    private EncerrarDesafioService encerrarService;

    @Autowired
    private ListarDesafiosDisponiveisService listarDesafiosDisponiveisService;

    @Autowired
    private ListarDesafiosCadastradosService listarDesafiosCadastradosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DesafioResponse criarDesafio(@RequestBody @Valid DesafioRequest desafioRequest) {
        return criarDesafioService.criar(desafioRequest);
    }

    @PutMapping("/contribuir/")
    @ResponseStatus(HttpStatus.OK)
    public NovaContribuicaoResponse contribuir(@RequestBody @Valid NovaContribuicaoRequest contribuicaoRequest ) {
        return contribuirService.contribuir(contribuicaoRequest);
    }

    @PutMapping("/{idDesafio}/encerrar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void encerrar(@PathVariable Integer idDesafio) {
        encerrarService.encerrar(idDesafio);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Desafio> listarDesafiosUsuarioParticipante() {
        return listarDesafiosDisponiveisService.listar();
    }

    @GetMapping("/listar/cadastrados")
    @ResponseStatus(HttpStatus.OK)
    public List<Desafio> listarDesafiosCadastrados() {
        return listarDesafiosCadastradosService.listar();
    }

}