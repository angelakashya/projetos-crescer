package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.controller.CorridaResponse;
import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.domain.Veiculo;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.repository.CorridaRepository;
import br.com.cwi.crescer.melevaai.repository.VeiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class CriarCorridaService {

    @Autowired
    CorridaRepository corridaRepository;

    @Autowired
    BuscarPassageiroPorCpfService buscarPassageiroPorCpfService;

    @Autowired
    VeiculoRepository veiculoRepository;


//    public CorridaResponse criarCorrida(@PathVariable("cpf") String cpf, @PathVariable("placa") String placa, @RequestBody @Valid CorridaRequest corridaRequest) {
//
//        ModelMapper mp = new ModelMapper();
//        Corrida corrida = mp.map(corridaRequest, Corrida.class);
//
//        corrida.setPassageiro(buscarPassageiroPorCpfService.buscar(cpf));
//        corrida.setIdCorrida(corridaRepository.size());
//        corrida.setVeiculo(veiculoRepository.findByPlaca(placa));
//
//        if (corrida.getVeiculo().getProprietario().getCnh().isVencida())
//            throw new ValidacaoNegocioException("CNH vencida");
//
//        Random r = new Random();
//
//        corrida.setHorarioChegada(LocalDateTime.now().plusMinutes(  r.nextInt((10 - 5) + 1) + 5  ));
//
//        corrida.setAvaliado(false);
//
//        corridas.add(corrida);
//
//        CorridaResponse corridaResponse = mp.map(corrida, CorridaResponse.class);
//
//
//        return corridaResponse;
//    }

}
