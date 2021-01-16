package br.com.cwi.crescer.tcc.angela.almeida.controller;


import br.com.cwi.crescer.tcc.angela.almeida.controller.request.AutenticarUsuarioRequest;
import br.com.cwi.crescer.tcc.angela.almeida.controller.request.UsuarioRequest;
import br.com.cwi.crescer.tcc.angela.almeida.controller.response.AutenticarUsuarioResponse;
import br.com.cwi.crescer.tcc.angela.almeida.controller.response.UsuarioResponse;
import br.com.cwi.crescer.tcc.angela.almeida.service.publico.AutenticarUsuarioService;
import br.com.cwi.crescer.tcc.angela.almeida.service.usuario.CadastrarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/publico/usuario")
@CrossOrigin
public class UsuarioPublicoController {

    @Autowired
    private CadastrarUsuarioService cadastrarUsuarioService;

    @Autowired
    private AutenticarUsuarioService autenticarUsuarioService;


    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse cadastrar(@RequestBody UsuarioRequest usuarioRequest) {
        return cadastrarUsuarioService.cadastrar(usuarioRequest);
    }

    @PostMapping("/autenticar")
    public AutenticarUsuarioResponse autenticar(@RequestBody AutenticarUsuarioRequest autenticarUsuarioRequest) {
       return autenticarUsuarioService.autenticar(autenticarUsuarioRequest);
    }

}
