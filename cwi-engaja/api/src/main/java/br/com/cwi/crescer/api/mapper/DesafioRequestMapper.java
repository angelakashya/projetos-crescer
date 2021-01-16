package br.com.cwi.crescer.api.mapper;

import br.com.cwi.crescer.api.controller.requestdto.DesafioRequest;
import br.com.cwi.crescer.api.domain.Desafio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DesafioRequestMapper {

    @Autowired
    ModelMapper mapper;

    public Desafio apply(DesafioRequest request) {
        return mapper.map(request, Desafio.class);
    }
}