package br.com.cwi.crescer.api.service;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.DesafioUsuarioContribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VerificarContribuicaoUsuarioService {

    @Autowired
    DesafioUsuarioContribuicaoRepository repository;

    public void verificar(Usuario usuario, Desafio desafio){
        if(repository.findByDesafioAndUsuario(desafio, usuario).isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já contribuiu com esse desafio.");

    }
}
