package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface MotoristaRepository extends Repository<Motorista, Integer> {

    List<Motorista> findAll();

    Optional<Motorista> findByCpf(String cpf);

    Motorista save(Motorista motorista);
}

