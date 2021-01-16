package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.TipoDesafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.service.usuario.BuscarUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissaoVisualizacaoService {

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    public boolean validar(Desafio desafio) {

        Usuario usuario = buscarUsuarioAutenticadoService.buscar();

        return (TipoDesafio.GLOBAL.equals(desafio.getTipoDesafio()) ||
                usuario.getNome().equals( desafio.getUsuario().getNome() ) ||
                usuario.getGestor().equals( desafio.getUsuario().getUser() ));

    }
}
