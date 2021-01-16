package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.domain.Veiculo;
import br.com.cwi.crescer.melevaai.repository.VeiculoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListarVeiculosService {

    @Autowired
    VeiculoRepository veiculoRepository;

    public List<Veiculo> listar() {

        return veiculoRepository.findAll();
    }
}
