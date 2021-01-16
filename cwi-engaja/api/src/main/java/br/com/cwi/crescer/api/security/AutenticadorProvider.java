package br.com.cwi.crescer.api.security;

import br.com.cwi.crescer.api.security.cwi.CWIUserResponse;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;

@Component
public class AutenticadorProvider extends AbstractUserDetailsAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(final UserDetails userDetails,
        final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {

    }

    @Override
    protected UserDetails retrieveUser(
        String username,
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {

        if (username == null) {
            throw new UsernameNotFoundException("Usuário não econtrado");
        }

        String token = username;

        String url = "https://auth-homolog.cwi.com.br/connect/introspect";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBasicAuth("crescer-api", "crescer-homolog");

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("token", token);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);


        try {

            ResponseEntity<CWIUserResponse> response = new RestTemplate().exchange(
                url,
                HttpMethod.POST,
                request,
                CWIUserResponse.class
            );

            CWIUserResponse userAuth = response.getBody();

            return new UsuarioAutenticado(
                userAuth.getUsuario(),
                userAuth.getActive()
            );

        } catch (Exception exception) {

            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "");
        }

    }
}
