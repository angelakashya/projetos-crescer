package br.com.cwi.crescer.api.service;

import br.com.cwi.crescer.api.controller.requestdto.LoginRequest;
import br.com.cwi.crescer.api.controller.responsedto.LoginResponse;
import br.com.cwi.crescer.api.domain.Usuario;
import br.com.cwi.crescer.api.validator.UsuarioGlobalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LoginService {

    @Autowired
    BuscarUsuarioService buscarUsuario;

    @Autowired
    UsuarioGlobalValidator usuarioGlobalValidator;

    @Autowired
    BuscarEquipeDoUsuarioService buscarEquipeService;


    public LoginResponse logar(LoginRequest dados) {

        String loginApi = "https://auth-homolog.cwi.com.br/connect/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth("crescer-app", "crescer-homolog");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "password");
        map.add("scope", "crescer-api");
        map.add("username", dados.getUser());
        map.add("password", dados.getPassword());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        try{
            ResponseEntity<LoginResponse> response = new RestTemplate().exchange(
                    loginApi,
                    HttpMethod.POST,
                    request,
                    LoginResponse.class
            );

            return response.getBody();

        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Algo deu errado ao fazer o login. Verifique as credenciais e tente novamente.");
        }

    }
}
