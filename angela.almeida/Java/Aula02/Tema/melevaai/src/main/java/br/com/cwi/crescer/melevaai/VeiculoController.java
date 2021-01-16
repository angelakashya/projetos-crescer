package br.com.cwi.crescer.melevaai;


import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.domain.Veiculo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    private static List<Veiculo> veiculos = new ArrayList<>();

    @GetMapping()
    public List<Veiculo> mostrarVeiculos() {
        return veiculos;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo adicionarVeiculo(@RequestBody Veiculo veiculo) {
        for(Veiculo veiculoList : veiculos) {
            if (veiculoList.getPlaca().equals(veiculo.getPlaca()))
                throw new IllegalArgumentException();
        }

        if (veiculo.getPlaca() == null)
            throw new IllegalArgumentException();
        veiculos.add(veiculo);
        return veiculo;
    }

}
