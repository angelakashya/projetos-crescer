package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Curtida;
import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.mapper.desafio.NovaCurtidaMapper;
import br.com.cwi.crescer.api.repository.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurtirDesafioService {

    @Autowired
    private NovaCurtidaMapper novaCurtidaMapper;

    @Autowired
    CurtidaRepository repository;

    public void curtir(Desafio desafio, Usuario usuario) {
        Curtida curtida = new Curtida();
        curtida = novaCurtidaMapper.apply(curtida, usuario, desafio);
        repository.save(curtida);
    }
}
