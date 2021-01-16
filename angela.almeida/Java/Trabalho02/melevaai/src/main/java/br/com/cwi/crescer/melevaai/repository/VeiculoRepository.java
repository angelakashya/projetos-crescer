package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Veiculo;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface VeiculoRepository extends Repository<Veiculo, Integer> {

    List<Veiculo> findAll();

    Optional<Veiculo> findByPlaca(String placa);

    Veiculo save(Veiculo veiculo);
}
