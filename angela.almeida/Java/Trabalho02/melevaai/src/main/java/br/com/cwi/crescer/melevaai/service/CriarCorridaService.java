package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.controller.request.CorridaRequest;
import br.com.cwi.crescer.melevaai.controller.response.CorridaResponse;
import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.repository.CorridaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class CriarCorridaService {

    @Autowired
    CorridaRepository corridaRepository;

    @PostMapping("/passageiros/{cpf}")
    @ResponseStatus(HttpStatus.CREATED)
    public CorridaResponse criarCorrida(@PathVariable("cpf") String cpf, @RequestBody @Valid CorridaRequest corridaRequest) {

        ModelMapper mp = new ModelMapper();
        Corrida corrida = mp.map(corridaRequest, Corrida.class);

        Random r = new Random();

        corrida.setDataHoraFim(LocalDateTime.now().plusMinutes(  r.nextInt((10 - 5) + 1) + 5  ));

        corridaRepository.save(corrida);

        CorridaResponse corridaResponse = mp.map(corrida, CorridaResponse.class);


        return corridaResponse;
    }

}
