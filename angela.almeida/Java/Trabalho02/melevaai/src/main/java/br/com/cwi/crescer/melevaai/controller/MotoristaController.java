package br.com.cwi.crescer.melevaai.controller;


import br.com.cwi.crescer.melevaai.controller.request.MotoristaRequest;
import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import br.com.cwi.crescer.melevaai.service.BuscarMotoristaPorCpfService;
import br.com.cwi.crescer.melevaai.service.CadastrarMotoristaService;
import br.com.cwi.crescer.melevaai.service.ListarMotoristaService;
import br.com.cwi.crescer.melevaai.service.SacarSaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private ListarMotoristaService listarMotoristaService;

    @Autowired
    private CadastrarMotoristaService cadastrarMotoristaService;

    @Autowired
    private BuscarMotoristaPorCpfService buscarMotoristaPorCpfService;

    @Autowired
    SacarSaldoService sacarSaldoService;

    @GetMapping
    public List<Motorista> listar() {

        return listarMotoristaService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MotoristaResponse cadastrar(@RequestBody MotoristaRequest motoristaRequest) {

        return cadastrarMotoristaService.cadastrar(motoristaRequest);
    }

    @GetMapping("/{cpf}")
    public MotoristaResponse buscarPorCpf(@PathVariable("cpf") String cpf) {

        return buscarMotoristaPorCpfService.buscar(cpf);
    }

    @PutMapping("/{cpf}/conta-virtual")
    @ResponseStatus(HttpStatus.OK)
    public void sacarSaldo(@PathVariable("cpf") String cpf, @RequestParam double saldo) {

        sacarSaldoService.sacarSaldo(cpf, saldo);
    }
}
