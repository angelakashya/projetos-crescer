package br.com.cwi.crescer.api.service.meta;

import br.com.cwi.crescer.api.controller.requestdto.DesafioRequest;
import br.com.cwi.crescer.api.domain.DesafioMeta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiltrarMetasValidasService {

    public List<DesafioMeta> filtrar(DesafioRequest request, Long maxParticipantes) {
        return request
                .getMetas()
                .stream()
                .filter(meta -> meta.getQuantidadeColaboradores() != null &&
                        meta.getQuantidadeColaboradores() > 0 &&
                        meta.getQuantidadeColaboradores() <= maxParticipantes)
                .collect(Collectors.toList());
    }
}
