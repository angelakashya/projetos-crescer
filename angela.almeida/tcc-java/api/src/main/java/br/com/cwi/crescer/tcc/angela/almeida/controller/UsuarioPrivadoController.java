package br.com.cwi.crescer.tcc.angela.almeida.controller;

import br.com.cwi.crescer.tcc.angela.almeida.domain.Usuario;
import br.com.cwi.crescer.tcc.angela.almeida.service.usuario.ListarUsuariosService;
import br.com.cwi.crescer.tcc.angela.almeida.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/privado/usuario")
public class UsuarioPrivadoController {

    @Autowired
    private ListarUsuariosService listarUsuariosService;

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listar() {
        return listarUsuariosService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> get(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping("/pessoas/{id}")
    public List<Usuario> getNaoAmigos(@PathVariable Integer id) {
        return service.findByIdUsuarioNotIn(id);
    }

    @PostMapping
    @ResponseBody
    public Usuario post(@RequestBody Usuario usuario) {
        return service.save(usuario);
    }
}
