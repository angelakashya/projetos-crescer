package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.PassageiroRequest;
import br.com.cwi.crescer.melevaai.controller.response.PassageiroResponse;
import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.repository.PassageiroRepository;
import br.com.cwi.crescer.melevaai.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {
    @Autowired
    PassageiroRepository passageiroRepository;

    @Autowired
    CadastrarPassageiroService cadastrarPassageiroService;

    @Autowired
    DeletarPassageiroService deletarPassageiroService;

    @Autowired
    BuscarPassageiroPorCpfService buscarPassageiroPorCpfService;

    @Autowired
    DepositarDinheiroNaCarteiraService depositarDinheiroNaCarteiraService;

    @Autowired
    ListarPassageirosService listarPassageirosService;

    @GetMapping
    public List<Passageiro> listar() {

        return listarPassageirosService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassageiroResponse cadastrar(@RequestBody PassageiroRequest passageiroRequest) {

        return cadastrarPassageiroService.cadastrar(passageiroRequest);
    }

    @DeleteMapping("/{cpf}")
    public void deletar(@PathVariable String cpf) {
        deletarPassageiroService.deletar(cpf);
    }

    @GetMapping("/{cpf}")
    public PassageiroResponse buscarPorCpf(@PathVariable("cpf") String cpf) {

        return buscarPassageiroPorCpfService.buscar(cpf);
    }

    @PutMapping("/{cpf}/conta-virtual")
    @ResponseStatus(HttpStatus.OK)
    public void depositarSaldo(@PathVariable("cpf") String cpf, @RequestParam double saldo) {

        depositarDinheiroNaCarteiraService.depositarSaldo(cpf, saldo);
    }

}
