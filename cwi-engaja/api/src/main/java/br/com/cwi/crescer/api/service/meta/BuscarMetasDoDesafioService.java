package br.com.cwi.crescer.api.service.meta;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioMeta;
import br.com.cwi.crescer.api.repository.DesafioMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarMetasDoDesafioService {

    @Autowired
    private DesafioMetaRepository repository;

    public List<DesafioMeta> buscar(Desafio desafio) {
        return repository.findByDesafio(desafio).orElseGet(ArrayList::new);
    }
}
