package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.controller.request.PassageiroRequest;
import br.com.cwi.crescer.melevaai.controller.response.PassageiroResponse;
import br.com.cwi.crescer.melevaai.domain.CPF;
import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.repository.PassageiroRepository;
import br.com.cwi.crescer.melevaai.validator.PassageiroRequestValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarPassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;


    @Autowired
    private PassageiroRequestValidator passageiroRequestValidator;

    public PassageiroResponse cadastrar(PassageiroRequest passageiroRequest) {

        final ModelMapper modelMapper = new ModelMapper();
        final Passageiro passageiro = modelMapper.map(passageiroRequest, Passageiro.class);
        passageiro.setCpf(new CPF(passageiroRequest.getCpf()));

        if(!passageiro.idadeMinimaValida()) {
            throw new ValidacaoNegocioException("Passageiro não possui idade minina");
        }

        if(passageiroRepository.exists(passageiro)) {
            throw new ValidacaoNegocioException("Passageiro já cadastrado");
        }

        passageiroRepository.save(passageiro);

        return modelMapper.map(passageiro, PassageiroResponse.class);
    }

}
