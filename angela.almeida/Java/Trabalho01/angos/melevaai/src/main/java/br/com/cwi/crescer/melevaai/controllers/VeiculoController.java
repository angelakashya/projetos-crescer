package br.com.cwi.crescer.melevaai.controllers;


import br.com.cwi.crescer.melevaai.controllers.request.VeiculoRequest;
import br.com.cwi.crescer.melevaai.controllers.response.VeiculoResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.domain.Veiculo;
import br.com.cwi.crescer.melevaai.exceptions.ValidacaoNegocioException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoController {


    public static List<Veiculo> veiculos = new ArrayList<>();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoResponse cadastrar(@RequestBody @Valid  VeiculoRequest veiculoRequest) {

        Motorista proprietario = MotoristaController.motoristas
                .stream()
                .filter(m -> m.getCpf().getNumero().equals(veiculoRequest.getCpfMotorista()))
                .findFirst()
                .orElseThrow(() -> new ValidacaoNegocioException());

        ModelMapper modelMapper = new ModelMapper();

        // de veiculoRequest para veiculo
        Veiculo veiculo = modelMapper.map(veiculoRequest, Veiculo.class);

        veiculo.setProprietario(proprietario);

        veiculos.add(veiculo);

        // de veiculo para veiculoResponse
        VeiculoResponse veiculoResponse = modelMapper.map(veiculo, VeiculoResponse.class);

        return veiculoResponse;
    }

    @GetMapping
    public List<Veiculo> listar() {
        return veiculos;
    }

}
