package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.domain.Veiculo;
import br.com.cwi.crescer.melevaai.repository.VeiculoRepository;
import br.com.cwi.crescer.melevaai.service.ListarVeiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    ListarVeiculosService listarVeiculosService;

    @GetMapping
    public List<Veiculo> listar() {

        return listarVeiculosService.listar();
    }
}
