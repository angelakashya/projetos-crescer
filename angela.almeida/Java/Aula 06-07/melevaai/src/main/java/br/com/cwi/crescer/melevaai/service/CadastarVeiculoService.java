package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.controller.request.VeiculoRequest;
import br.com.cwi.crescer.melevaai.controller.response.VeiculoResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.domain.Veiculo;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import br.com.cwi.crescer.melevaai.repository.VeiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
public class CadastarVeiculoService {
    MotoristaRepository motoristaRepository;
    VeiculoRepository veiculoRepository;

    public VeiculoResponse cadastrar(@RequestBody @Valid VeiculoRequest veiculoRequest) {

        Motorista proprietario = motoristaRepository.findAll()
                .stream()
                .filter(m -> m.getCpf().getNumero().equals(veiculoRequest.getCpf()))
                .findFirst()
                .orElseThrow(() -> new ValidacaoNegocioException("Erro"));

        ModelMapper modelMapper = new ModelMapper();

        Veiculo veiculo = modelMapper.map(veiculoRequest, Veiculo.class);


        if (veiculoRepository.exists(veiculo))
            throw new ValidacaoNegocioException("Veiculo já cadastrado");

        veiculo.setProprietario(proprietario);

        if (veiculo.getProprietario().getCnh().isVencida())
            throw new ValidacaoNegocioException("Cnh Vencida");

        veiculoRepository.save(veiculo);

        VeiculoResponse veiculoResponse = modelMapper.map(veiculo, VeiculoResponse.class);

        return veiculoResponse;

    }

}
