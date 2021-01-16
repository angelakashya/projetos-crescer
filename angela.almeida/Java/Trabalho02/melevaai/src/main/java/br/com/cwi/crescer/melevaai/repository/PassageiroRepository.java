package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Passageiro;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface PassageiroRepository extends Repository<Passageiro, Integer> {

    List<Passageiro> findAll();

    Optional<Passageiro> findByCpf(String cpf);

    Passageiro save(Passageiro passageiro);
}
