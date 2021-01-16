package br.com.cwi.crescer.melevaai.repository;


import br.com.cwi.crescer.melevaai.domain.Passageiro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PassageiroRepository {
    private static List<Passageiro> passageiros = new ArrayList();

    public List<Passageiro> findAll() {
        return passageiros;
    }

    public Optional <Passageiro> findByCpf(String cpf) {
        return passageiros
                .stream()
                .filter(p -> p.getCpf().getNumero().equals(cpf))
                .findFirst();
    }

    public void delete(Passageiro passageiro) {

        passageiros.remove(passageiro);
    }

    public boolean exists(Passageiro passageiro) {

        return passageiros.contains(passageiro);
    }

    public Passageiro save(Passageiro passageiro) {

        passageiros.add(passageiro);

        return passageiro;
    }
}
