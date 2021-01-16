package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.controller.responsedto.ListarDetalhesDesafioResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListarDetalhesDesafioResponseMapper {

    @Autowired
    ModelMapper mapper;

    public ListarDetalhesDesafioResponse apply(Desafio desafio) {
        return mapper.map(desafio, ListarDetalhesDesafioResponse.class);
    }
}
