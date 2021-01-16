package br.com.cwi.crescer.tcc.angela.almeida.controller;

import br.com.cwi.crescer.tcc.angela.almeida.domain.Amigo;
import br.com.cwi.crescer.tcc.angela.almeida.service.amigo.AmigoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/privado/amigo")
public class AmigoContoller {

    @Autowired
    private AmigoService service;

    @GetMapping("/{id}")
    public Optional<Amigo> get(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Amigo id) {
        service.delete(id);
    }

    @GetMapping
    public List<Amigo> get() {
        return service.listarTodos();
    }

    @GetMapping("/aceitos")
    public Long countAceitos(@RequestParam Integer idUsuario, @RequestParam boolean aceito) {
        return service.countByIdUsuarioAndAceito(idUsuario, aceito);
    }

    @PostMapping
    @ResponseBody
    public Amigo post(@RequestBody Amigo amigo) {
        return service.save(amigo);
    }

    @GetMapping("/lista/usuario")
    public List<Amigo> getAmigosByUsuario(@RequestParam Integer idUsuario, @RequestParam boolean aceito) {
        return service.findAllByIdUsuarioAndAceito(idUsuario, aceito);
    }

    @GetMapping("/lista/amigo")
    public List<Amigo> getAmigosByAmigo(@RequestParam Integer idUsuario, @RequestParam boolean aceito) {
        return service.findAllByIdAmigoAndAceito(idUsuario, aceito);
    }

    @PutMapping
    public Amigo update(@RequestParam Integer idUsuario, @RequestParam boolean aceito) {
        return null;
    }
}
