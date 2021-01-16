package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Veiculo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VeiculoRepository {

    private static List<Veiculo> veiculos = new ArrayList<>();

    public List<Veiculo> findAll() {

        return veiculos;
    }

    public Optional<Veiculo> findByPlaca(String placa) {
        return veiculos
                .stream()
                .filter(v -> v.getPlaca().equals(placa))
                .findFirst();
    }

    public void delete(Veiculo veiculo) {

        veiculos.remove(veiculo);
    }

    public boolean exists(Veiculo veiculo) {

        return veiculos.contains(veiculo);
    }

    public Veiculo save(Veiculo veiculo) {

        veiculos.add(veiculo);

        return veiculo;
    }
}
