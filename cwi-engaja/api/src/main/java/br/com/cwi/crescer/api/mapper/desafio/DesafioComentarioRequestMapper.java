package br.com.cwi.crescer.api.mapper.desafio;

import br.com.cwi.crescer.api.controller.requestdto.DesafioComentarioRequest;
import br.com.cwi.crescer.api.domain.DesafioComentario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DesafioComentarioRequestMapper {

    @Autowired
    ModelMapper mapper;

    public DesafioComentario apply(DesafioComentarioRequest request) {
        return mapper.map(request, DesafioComentario.class);
    }

}
