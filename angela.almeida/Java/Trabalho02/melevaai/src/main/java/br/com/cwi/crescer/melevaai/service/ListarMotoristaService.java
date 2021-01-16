package br.com.cwi.crescer.melevaai.service;


import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListarMotoristaService {

    @Autowired
    MotoristaRepository motoristaRepository;

    public List<Motorista> listar() {

        return motoristaRepository.findAll();
    }
}
