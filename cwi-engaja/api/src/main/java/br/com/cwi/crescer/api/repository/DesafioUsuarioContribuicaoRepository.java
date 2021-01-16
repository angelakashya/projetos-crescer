package br.com.cwi.crescer.api.repository;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import br.com.cwi.crescer.api.domain.Usuario;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface DesafioUsuarioContribuicaoRepository extends Repository<DesafioUsuarioContribuicao, Integer> {

    void save (DesafioUsuarioContribuicao contribuicao);

    Optional<DesafioUsuarioContribuicao> findByDesafioAndUsuario(Desafio desafio, Usuario usuario);
}
