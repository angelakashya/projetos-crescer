package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioMeta;
import org.springframework.stereotype.Service;

@Service
public class VerificarPrestacaoDeContasService {

    public void verificar(Desafio desafio) {
        for (DesafioMeta meta : desafio.getMetas()){
            meta.setPrestacaoFeita(meta.getDescricaoPrestacao() != null || meta.getImagemPrestacao() != null);
        }
    }
}
