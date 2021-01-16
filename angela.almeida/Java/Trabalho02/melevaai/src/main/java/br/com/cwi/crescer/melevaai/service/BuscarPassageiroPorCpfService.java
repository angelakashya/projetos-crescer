package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.controller.response.PassageiroResponse;
import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.exception.RegistroNaoEncontradoException;
import br.com.cwi.crescer.melevaai.mapper.PassageiroResponseMapper;
import br.com.cwi.crescer.melevaai.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarPassageiroPorCpfService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Autowired
    private PassageiroResponseMapper mapper;

    public PassageiroResponse buscar(final String cpf) {

        Optional<Passageiro> passageiro = passageiroRepository.findByCpf(cpf);

        if(!passageiro.isPresent()) {
            throw new RegistroNaoEncontradoException(Passageiro.class.getName());
        }

        return mapper.apply(passageiro.get());
    }
}

