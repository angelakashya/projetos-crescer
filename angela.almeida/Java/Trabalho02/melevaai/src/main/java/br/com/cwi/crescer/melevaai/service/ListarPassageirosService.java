package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.repository.PassageiroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListarPassageirosService {

    @Autowired
    PassageiroRepository passageiroRepository;

    public List<Passageiro> listar() {
        return passageiroRepository.findAll();
    }
}
