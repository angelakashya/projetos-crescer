package br.com.cwi.crescer.api.service.usuario;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.DesafioUsuarioContribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerificarSeUsuarioJaContribuiuService {

    @Autowired
    private DesafioUsuarioContribuicaoRepository desafioUsuarioContribuicaoRepository;

    public boolean jaContribuiu(Desafio desafio, Usuario usuario) {
        Optional<DesafioUsuarioContribuicao> contribuicao = desafioUsuarioContribuicaoRepository
                .findByDesafioAndUsuario(desafio, usuario);
        return contribuicao.isPresent();
    }
}
