package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.exception.RegistroNaoEncontradoException;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class DeletarMotoristaService {

    @Autowired
    public MotoristaRepository motoristaRepository;

    public void deletar(@PathVariable String cpf) {
        final Optional<Motorista> motorista = motoristaRepository.findByCpf(cpf);

        if (!motorista.isPresent()) {
            throw new RegistroNaoEncontradoException(Motorista.class.getName());
        }

        motoristaRepository.delete(motorista.get());
    }
}
