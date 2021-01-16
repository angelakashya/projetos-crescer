package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.PassageiroRequest;
import br.com.cwi.crescer.melevaai.controller.response.PassageiroResponse;
import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.repository.PassageiroRepository;
import br.com.cwi.crescer.melevaai.service.CadastrarPassageiroService;
import br.com.cwi.crescer.melevaai.service.DepositarDinheiroNaContaService;
import br.com.cwi.crescer.melevaai.service.ListarPassageirosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    @Autowired
    PassageiroRepository passageiroRepository;

    @Autowired
    ListarPassageirosService listarPassageirosService;

    @Autowired
    CadastrarPassageiroService cadastrarPassageiroService;

    @Autowired
    DepositarDinheiroNaContaService depositarDinheiroNaContaService;

    @GetMapping
    public List<Passageiro> listar() {
        return listarPassageirosService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassageiroResponse cadastrar(@RequestBody PassageiroRequest passageiroRequest) {

        return cadastrarPassageiroService.cadastrar(passageiroRequest);
    }

    @PutMapping("/{cpf}/conta-virtual")
    @ResponseStatus(HttpStatus.OK)
    public void depositarSaldo(@PathVariable("cpf") String cpf, @RequestParam double saldo) {

        depositarDinheiroNaContaService.depositarSaldo(cpf, saldo);
    }

}
