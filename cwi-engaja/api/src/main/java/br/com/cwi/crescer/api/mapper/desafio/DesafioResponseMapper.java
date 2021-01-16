package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.controller.responsedto.DesafioResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DesafioResponseMapper {

    @Autowired
    ModelMapper mapper;

    public DesafioResponse apply(Desafio desafio) {
        return mapper.map(desafio, DesafioResponse.class);
    }

}