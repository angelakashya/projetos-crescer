package br.com.cwi.crescer.api.service.meta;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioMeta;
import br.com.cwi.crescer.api.repository.DesafioMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalvarMetaService {

    @Autowired
    private DesafioMetaRepository desafioMetaRepository;

    public void salvar(List<DesafioMeta> metas, Desafio desafio) {

        for (DesafioMeta meta : metas) {
            meta.setDesafio(desafio);
            desafioMetaRepository.save(meta);
        }
    }
}
