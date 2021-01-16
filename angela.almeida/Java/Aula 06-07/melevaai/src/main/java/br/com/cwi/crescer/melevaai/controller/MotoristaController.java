package br.com.cwi.crescer.melevaai.controller;

import java.util.List;

import br.com.cwi.crescer.melevaai.service.DeletarMotoristaService;
import br.com.cwi.crescer.melevaai.service.SacarSaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.cwi.crescer.melevaai.controller.request.MotoristaRequest;
import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import br.com.cwi.crescer.melevaai.service.BuscarMotoristaPorCpfService;
import br.com.cwi.crescer.melevaai.service.CadastrarMotoristaService;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private BuscarMotoristaPorCpfService buscarMotoristaPorCpfService;

    @Autowired
    private CadastrarMotoristaService cadastrarMotoristaService;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private DeletarMotoristaService deletarMotoristaService;

    @Autowired
    private SacarSaldoService sacarSaldoService;


    @GetMapping
    public List<Motorista> listar() {
        return motoristaRepository.findAll();
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


    @DeleteMapping("/{cpf}")
    public void deletar(@PathVariable String cpf) {

        deletarMotoristaService.deletar(cpf);
    }

    @PutMapping("/{cpfmotorista}/conta-virtual")
    @ResponseStatus(HttpStatus.OK)
    public void sacarSaldo(@PathVariable("cpfmotorista") String cpf, @RequestParam double saldo) {

        sacarSaldoService.sacarSaldo(cpf, saldo);
    }
}

