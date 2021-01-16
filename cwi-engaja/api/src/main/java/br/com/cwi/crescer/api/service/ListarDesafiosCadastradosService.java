package br.com.cwi.crescer.api.service;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.TipoDesafio;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListarDesafiosCadastradosService {

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    private DesafioRepository desafioRepository;

    public List<Desafio> listar() {
        List<Desafio> desafios = new ArrayList<>();
        Usuario usuario = buscarUsuarioAutenticadoService.buscar();
        Optional<List<Desafio>> listaDesafios = desafioRepository.findByUsuario(usuario);
        if (listaDesafios.isPresent()) {
            desafios = listaDesafios.get();
        }
        return desafios;
    }
}