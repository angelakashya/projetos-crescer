package br.com.cwi.crescer.melevaai.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.melevaai.domain.Motorista;

@Repository
public class MotoristaRepository {

    private static List<Motorista> motoristas = new ArrayList<>();

    public List<Motorista> findAll() {

        return motoristas;
    }

    public Optional<Motorista> findByCpf(String cpf) {

        return motoristas
                .stream()
                .filter(m -> m.getCpf().getNumero().equals(cpf))
                .findFirst();
    }

    public void delete(Motorista motorista) {

        motoristas.remove(motorista);
    }

    public boolean exists(Motorista motorista) {

        return motoristas.contains(motorista);
    }

    public Motorista save(Motorista motorista) {

        motoristas.add(motorista);

        return motorista;
    }
}

