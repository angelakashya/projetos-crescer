package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.repository.CorridaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListarCorridasService {

    @Autowired
    CorridaRepository corridaRepository;

    public List<Corrida> listar() {

        return corridaRepository.findAll();
    }
}
