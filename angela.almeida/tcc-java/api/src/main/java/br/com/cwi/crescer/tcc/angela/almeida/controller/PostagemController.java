package br.com.cwi.crescer.tcc.angela.almeida.controller;

import br.com.cwi.crescer.tcc.angela.almeida.domain.Amigo;
import br.com.cwi.crescer.tcc.angela.almeida.domain.Postagem;
import br.com.cwi.crescer.tcc.angela.almeida.domain.Usuario;
import br.com.cwi.crescer.tcc.angela.almeida.service.amigo.AmigoService;
import br.com.cwi.crescer.tcc.angela.almeida.service.postagem.PostagemService;
import br.com.cwi.crescer.tcc.angela.almeida.service.usuario.UsuarioService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/privado/postagem")
public class PostagemController {

    @Autowired
    private PostagemService postService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AmigoService amigosSerivce;

    @GetMapping
    public List<Postagem> get() {
        return postService.findAll();
    }

//    @GetMapping(value = "/lista")
//    public Page<Postagem> getPostByIdUsuario(@RequestParam Integer id, @RequestParam Integer pagina) {
//        List<Amigo> amigos = amigosSerivce.findAllByIdUsuario(id);
//        List<Usuario> usuarios = new ArrayList<>();
//
//        usuarios.add(usuarioService.findById(id).get());
//
//        amigos.forEach((a) -> {
//            usuarios.add(a.getIdAmigo());
//        });
//
//        return postService.findByIdUsuarioInOrderByIdDesc(usuarios, new PageRequest(pagina, 20));
//    }

    @PostMapping
    @ResponseBody
    public Postagem post(@RequestBody Postagem post) {
        return postService.save(post);
    }
}