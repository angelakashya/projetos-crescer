package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.repository.CorridaRepository;
import br.com.cwi.crescer.melevaai.service.ListarCorridasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/corridas")
public class CorridaController {

    @Autowired
    CorridaRepository corridaRepository;

    @Autowired
    ListarCorridasService listarCorridasService;

    @GetMapping
    public List<Corrida> listar() {
        return listarCorridasService.listar();
    }
}
