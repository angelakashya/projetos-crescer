package br.com.cwi.crescer.melevaai.mapper;

import org.springframework.stereotype.Component;

import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.domain.CarteiraNacionalHabilitacao;
import br.com.cwi.crescer.melevaai.domain.Motorista;

@Component
public class MotoristaResponseMapper {

    public MotoristaResponse apply(Motorista motorista) {

        CarteiraNacionalHabilitacao cnh = motorista.getCnh();

        MotoristaResponse response = new MotoristaResponse();
        response.setDataNascimento(motorista.getDataNascimento());
        response.setEmail(motorista.getEmail());
        response.setNome(motorista.getNome());
        response.setOcupado(motorista.isOcupado());
        response.setCategoriaCnh(cnh.getCategoria());
        response.setNumeroCnh(cnh.getNumero());
        response.setNumeroCpf(motorista.getCpf().getNumero());

        return response;
    }
}

