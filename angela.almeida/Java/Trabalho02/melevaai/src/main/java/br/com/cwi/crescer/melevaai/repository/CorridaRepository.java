package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Corrida;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CorridaRepository extends Repository<Corrida, Integer> {

    List<Corrida>  findAll();

    Corrida save(Corrida corrida);

}
