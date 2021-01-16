package br.com.cwi.crescer.tcc.angela.almeida.controller;


import br.com.cwi.crescer.tcc.angela.almeida.domain.Curtida;
import br.com.cwi.crescer.tcc.angela.almeida.service.curtida.CurtidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/privado/curtida")
public class CurtidaController {

    @Autowired
    private CurtidaService service;

    @PostMapping
    @ResponseBody
    public Curtida post(@RequestBody Curtida curtida) {
        return service.save(curtida);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Curtida curtida) {
        service.delete(curtida);
    }

    @GetMapping("/count/{id}")
    public Long countByPost(@PathVariable Integer id) {
        return service.countByIdPost(id);
    }

    @GetMapping(value = "/postagem/{id}")
    public List<Curtida> getByPost(@PathVariable Integer id) {
        return service.findByIdPostagem(id);
    }
}
