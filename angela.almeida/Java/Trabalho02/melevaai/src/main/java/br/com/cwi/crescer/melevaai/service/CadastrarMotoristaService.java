package br.com.cwi.crescer.melevaai.service;


import br.com.cwi.crescer.melevaai.controller.request.MotoristaRequest;
import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import br.com.cwi.crescer.melevaai.validator.MotoristaRequestValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarMotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private ValidarCnhService validarCnhService;

    @Autowired
    private MotoristaRequestValidator validator;

    public MotoristaResponse cadastrar(MotoristaRequest motoristaRequest) {

        validator.accept(motoristaRequest);

        final ModelMapper modelMapper = new ModelMapper();
        final Motorista motorista = modelMapper.map(motoristaRequest, Motorista.class);
        motorista.setCpf(motoristaRequest.getCpf());

        if (!motorista.idadeMinimaValida()) {
            throw new ValidacaoNegocioException("Erro ao cadastrar motorista. Não possui idade mínima.");
        }

        // exemplo de como segmentar o código
        validarCnhService.validar(motoristaRequest.getCnh());

        motoristaRepository.save(motorista);

        return modelMapper.map(motorista, MotoristaResponse.class);
    }

}
