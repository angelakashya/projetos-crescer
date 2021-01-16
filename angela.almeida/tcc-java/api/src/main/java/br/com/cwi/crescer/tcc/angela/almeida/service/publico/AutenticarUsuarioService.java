package br.com.cwi.crescer.tcc.angela.almeida.service.publico;


import br.com.cwi.crescer.tcc.angela.almeida.controller.request.AutenticarUsuarioRequest;
import br.com.cwi.crescer.tcc.angela.almeida.controller.response.AutenticarUsuarioResponse;
import br.com.cwi.crescer.tcc.angela.almeida.controller.response.UsuarioAutenticadoResponse;
import br.com.cwi.crescer.tcc.angela.almeida.domain.Usuario;
import br.com.cwi.crescer.tcc.angela.almeida.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class AutenticarUsuarioService {

    @Autowired
    private UsuarioService usuarioService;

    private String url = "http://52.191.131.0:3000/";


    public AutenticarUsuarioResponse autenticar(AutenticarUsuarioRequest autenticarRequest) {

        RestTemplate restTemplate = new RestTemplate();
        try {
            URI uri = new URI(url);

            ResponseEntity<AutenticarUsuarioResponse> result = restTemplate.postForEntity(
                    uri + "login",
                    autenticarRequest,
                    AutenticarUsuarioResponse.class
            );

            AutenticarUsuarioResponse usuarioResponse = new AutenticarUsuarioResponse();
            usuarioResponse.setToken(result.getBody().getToken());

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Authorization", usuarioResponse.getToken());
            ResponseEntity<UsuarioAutenticadoResponse> resultAutenticado = restTemplate.exchange(
                    uri + "me",
                    HttpMethod.GET,
                    new HttpEntity<Object>(headers),
                    UsuarioAutenticadoResponse.class);

            Usuario usuario =  usuarioService.findByEmail(resultAutenticado.getBody().getEmail());
            usuarioResponse.setId(usuario.getId());
            usuarioResponse.setEmail(usuario.getEmail());
            usuarioResponse.setImagem(usuario.getImagemPerfil());
            usuarioResponse.setApelido(usuario.getApelido());
            usuarioResponse.setNomeCompleto(usuario.getNomeCompleto());

            return  usuarioResponse;

        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }

    }

}
