package br.com.cwi.crescer.api.service;

import br.com.cwi.crescer.api.controller.requestdto.DesafioRequest;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioMeta;
import br.com.cwi.crescer.api.repository.DesafioMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalvarMetaService {

    @Autowired
    private DesafioMetaRepository desafioMetaRepository;

    public List<DesafioMeta> salvar(DesafioRequest desafioRequest, Desafio desafio) {
        List<DesafioMeta> listaMeta = new ArrayList<>();
        if (desafioRequest.getMetas() != null) {
            for (DesafioMeta meta : desafioRequest.getMetas()) {
                meta.setDesafio(desafio);
                desafioMetaRepository.save(meta);
                listaMeta.add(meta);
            }
        }
        return listaMeta;
    }
}
