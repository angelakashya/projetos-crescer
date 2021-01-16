package br.com.cwi.crescer.tcc.angela.almeida.controller;

import br.com.cwi.crescer.tcc.angela.almeida.domain.Comentario;
import br.com.cwi.crescer.tcc.angela.almeida.service.comentario.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/privado/comentario")
public class CometarioController {

    @Autowired
    private ComentarioService service;

    @GetMapping("/{id}")
    public List<Comentario> findAllByIdPost(@PathVariable Integer id) {
        return service.findAllByIdPost(id);
    }

    @PostMapping
    @ResponseBody
    public Comentario post(@RequestBody Comentario comentario) {
        return service.save(comentario);
    }

    @GetMapping("/count/{id}")
    public Long countComentarioPorPost(@PathVariable Integer id) {
        return service.countByIdPostagem(id);
    }
}
