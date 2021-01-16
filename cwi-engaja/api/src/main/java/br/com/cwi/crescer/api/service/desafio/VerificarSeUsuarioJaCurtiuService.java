package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Curtida;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerificarSeUsuarioJaCurtiuService {

    @Autowired
    private CurtidaRepository repository;

    public boolean verificar(Desafio desafio, Usuario usuario){
        Optional<Curtida> curtidaOptional = repository.findByDesafioAndUsuario(desafio, usuario);

        return curtidaOptional.isPresent();
    }
}
