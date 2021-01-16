package br.com.cwi.crescer.api.service.meta;

import br.com.cwi.crescer.api.domain.DesafioMeta;
import br.com.cwi.crescer.api.repository.DesafioMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BuscarMetaPorIdService {

    @Autowired
    private DesafioMetaRepository repository;

    public DesafioMeta buscar(Integer idMeta) {
        return repository
                .findById(idMeta)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "A meta informada não existe."));
    }
}
