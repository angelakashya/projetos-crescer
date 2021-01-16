package br.com.cwi.crescer.api.repository;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.TipoDesafio;
import br.com.cwi.crescer.api.domain.Usuario;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface DesafioRepository extends Repository<Desafio, Integer> {
    Desafio save(Desafio desafio);
    Optional<List<Desafio>> findByUsuario(Usuario usuario);
    Optional<Desafio> findById(Integer id);
    Optional<List<Desafio>> findByTipoDesafio(TipoDesafio tipoDesafio);
    Optional<List<Desafio>> findByTipoDesafioAndUsuario(TipoDesafio tipoDesafio, Usuario usuario);
}