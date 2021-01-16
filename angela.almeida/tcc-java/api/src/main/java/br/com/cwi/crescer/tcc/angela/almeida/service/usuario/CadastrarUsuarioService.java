package br.com.cwi.crescer.tcc.angela.almeida.service.usuario;

import br.com.cwi.crescer.tcc.angela.almeida.controller.request.UserRequest;
import br.com.cwi.crescer.tcc.angela.almeida.controller.request.UsuarioRequest;
import br.com.cwi.crescer.tcc.angela.almeida.controller.response.AutenticarUsuarioResponse;
import br.com.cwi.crescer.tcc.angela.almeida.controller.response.CadastarUsuarioResponse;
import br.com.cwi.crescer.tcc.angela.almeida.controller.response.UsuarioResponse;
import br.com.cwi.crescer.tcc.angela.almeida.domain.Usuario;
import br.com.cwi.crescer.tcc.angela.almeida.repository.UsuarioRepository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Service
public class CadastrarUsuarioService {

    private String url = "http://52.191.131.0:3000/register";

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponse cadastrar(UsuarioRequest usuarioRequest) {

        List<String> roles = new ArrayList<String>();
        roles.add("USER");

        final ModelMapper modelMapper = new ModelMapper();
        final Usuario usuario = modelMapper.map(usuarioRequest, Usuario.class);

        RestTemplate restTemplate = new RestTemplate();
        try {
            URI uri = new URI(url);

            UserRequest userRequest = new UserRequest(usuario.getEmail(), usuario.getNomeCompleto(), "Fontoura", usuario.getSenha(), roles);

            ResponseEntity<CadastarUsuarioResponse> result = restTemplate.postForEntity(
                    uri,
                    userRequest,
                    CadastarUsuarioResponse.class

            );

            CadastarUsuarioResponse usuarioResponse = new CadastarUsuarioResponse();
            usuarioResponse.setId(result.getBody().getId());

            usuarioRepository.save(usuario);

        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }

        return modelMapper.map(usuario, UsuarioResponse.class);
    }


}
