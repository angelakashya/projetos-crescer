package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Status;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import br.com.cwi.crescer.api.validator.desafio.CriadorDesafioValidator;
import br.com.cwi.crescer.api.validator.desafio.DesafioAtivoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncerrarDesafioService {

    @Autowired
    private BuscarDesafioPorIdService buscarDesafio;

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuario;

    @Autowired
    private DesafioAtivoValidator desafioAtivoValidator;

    @Autowired
    private CriadorDesafioValidator criadorValidator;

    @Autowired
    private DesafioRepository repository;

    public Desafio encerrar(Integer idDesafio) {
        Desafio desafio = buscarDesafio.buscar(idDesafio);

        desafioAtivoValidator.validar(desafio);

        Usuario usuario = buscarUsuario.buscar();

        criadorValidator.validar(desafio, usuario);

        desafio.setStatus(Status.ENCERRADO);

        repository.save(desafio);

        return desafio;
    }
}
