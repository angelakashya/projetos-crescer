package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.exception.RegistroNaoEncontradoException;
import br.com.cwi.crescer.melevaai.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class DeletarPassageiroService {

    @Autowired
    PassageiroRepository passageiroRepository;

    public void deletar(@PathVariable String cpf) {
        final Optional<Passageiro> passageiro = passageiroRepository.findByCpf(cpf);

        if(!passageiro.isPresent()) {
            throw new RegistroNaoEncontradoException(Passageiro.class.getName());
        }

        passageiroRepository.delete(passageiro.get());
    }
}
