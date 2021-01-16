package br.com.cwi.crescer.api.mapper.prestacaodecontas;

import br.com.cwi.crescer.api.controller.responsedto.PrestacaoDeContasResponse;
import br.com.cwi.crescer.api.domain.DesafioMeta;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrestacaoDecontasResponseMapper {

    @Autowired
    private ModelMapper mapper;

    public PrestacaoDeContasResponse apply(DesafioMeta meta) {
        return mapper.map(meta, PrestacaoDeContasResponse.class);
    }

}