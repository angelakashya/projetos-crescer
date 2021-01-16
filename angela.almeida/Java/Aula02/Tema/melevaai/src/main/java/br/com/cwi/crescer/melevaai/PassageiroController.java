package br.com.cwi.crescer.melevaai;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.domain.Passageiro;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/passageiro")
public class PassageiroController {
    private static List<Passageiro> passageiros = new ArrayList<>();

    @GetMapping()
    public List<Passageiro> mostrarPassageiros() {

        return passageiros;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Passageiro criarPassageiro(@RequestBody Passageiro passageiro) {
        for (Passageiro passageiroList : passageiros) {
            if (passageiroList.getCpf().getNumero().equals(passageiro.getCpf().getNumero()))
                throw new IllegalArgumentException();
        }
        if (passageiro.getCpf() == null)
            throw new IllegalArgumentException();
        passageiros.add(passageiro);
        return passageiro;
    }
}
