package br.com.cwi.crescer.api.service;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Status;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import br.com.cwi.crescer.api.validator.CriadorDesafioValidator;
import br.com.cwi.crescer.api.validator.DesafioAtivoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncerrarDesafioService {

    @Autowired
    BuscarDesafioPorIdService buscarDesafio;

    @Autowired
    BuscarUsuarioAutenticadoService buscarUsuario;

    @Autowired
    DesafioAtivoValidator desafioAtivoValidator;

    @Autowired
    CriadorDesafioValidator criadorValidator;

    @Autowired
    DesafioRepository repository;

    public void encerrar(Integer idDesafio) {
        Desafio desafio = buscarDesafio.buscar(idDesafio);

        desafioAtivoValidator.validar(desafio);

        Usuario usuario = buscarUsuario.buscar();

        criadorValidator.validar(desafio, usuario);

        desafio.setStatus(Status.ENCERRADO);

        repository.save(desafio);

    }
}
