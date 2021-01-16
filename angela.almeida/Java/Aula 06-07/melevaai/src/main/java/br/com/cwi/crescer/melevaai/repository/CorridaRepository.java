package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Corrida;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CorridaRepository {

    private static List<Corrida> corridas = new ArrayList<>();

    public List<Corrida> findAll() {

        return corridas;
    }

    public Optional<Corrida> findById (int idCorrida) {

        return corridas
                .stream()
                .filter(c -> c.getIdCorrida() == (idCorrida))
                .findFirst();
    }

    public void delete(Corrida corrida) {

        corridas.remove(corrida);
    }

    public boolean exists(Corrida corrida) {

        return corridas.contains(corrida);
    }

    public Corrida save(Corrida corrida) {

        corridas.add(corrida);

        return corrida;
    }

    public int size() {

        return corridas.size();
    }
}
