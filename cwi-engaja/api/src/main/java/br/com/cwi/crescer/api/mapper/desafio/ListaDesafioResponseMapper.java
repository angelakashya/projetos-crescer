package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.controller.responsedto.ListarDesafiosResponse;
import br.com.cwi.crescer.api.domain.Desafio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListaDesafioResponseMapper {

    @Autowired
    ModelMapper mapper;

    public ListarDesafiosResponse apply(Desafio desafio) {
        return mapper.map(desafio, ListarDesafiosResponse.class);
    }
}
