package br.com.cwi.crescer.melevaai.mapper;

import br.com.cwi.crescer.melevaai.controller.response.PassageiroResponse;
import br.com.cwi.crescer.melevaai.domain.Passageiro;
import org.springframework.stereotype.Component;

@Component
public class PassageiroResponseMapper {

    public PassageiroResponse apply(Passageiro passageiro) {

        PassageiroResponse response = new PassageiroResponse();
        response.setDataNascimento(passageiro.getDataNascimento());
        response.setEmail(passageiro.getEmail());
        response.setNome(passageiro.getNomeCompleto());
        response.setNumeroCpf(passageiro.getCpf());

        return response;
    }
}

