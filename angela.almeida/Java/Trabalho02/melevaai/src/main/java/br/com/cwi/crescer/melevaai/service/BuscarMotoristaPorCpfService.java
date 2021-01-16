package br.com.cwi.crescer.melevaai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.exception.RegistroNaoEncontradoException;
import br.com.cwi.crescer.melevaai.mapper.MotoristaResponseMapper;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;

@Service
public class BuscarMotoristaPorCpfService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private MotoristaResponseMapper mapper;

    public MotoristaResponse buscar(final String cpf) {

        Optional<Motorista> motorista = motoristaRepository.findByCpf(cpf);

        if (!motorista.isPresent()) {
            throw new RegistroNaoEncontradoException(Motorista.class.getName());
        }

        return mapper.apply(motorista.get());
    }
}

