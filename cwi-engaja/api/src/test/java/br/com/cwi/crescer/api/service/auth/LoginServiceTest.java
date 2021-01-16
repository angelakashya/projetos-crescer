package br.com.cwi.crescer.api.service.auth;

import br.com.cwi.crescer.api.controller.requestdto.LoginRequest;
import br.com.cwi.crescer.api.controller.responsedto.LoginResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.ArgumentMatchers.eq;


@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    @InjectMocks
    LoginService tested;

    @Mock
    RestTemplate restTemplate;

    LoginRequest dados;

    LoginResponse response;

    @Before
    public void setup() {
        dados = new LoginRequest();
        response = new LoginResponse();
    }

    @Test
    public void deveLogarComSucesso() {
        dados.setUser("joao.rocha");
        dados.setPassword("senha");

        String url = "https://auth-homolog.cwi.com.br/connect/token";

        response.setToken("token");

        ResponseEntity<LoginResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        Mockito.when(restTemplate.exchange(eq(url), eq(HttpMethod.POST), Mockito.any(), eq(LoginResponse.class)))
                .thenReturn(responseEntity);

        LoginResponse result = tested.logar(dados);

        Assert.assertNotNull(result);

        Mockito.verify(restTemplate).exchange(eq(url), eq(HttpMethod.POST), Mockito.any(), eq(LoginResponse.class));
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoLoginFalhar() {
        dados.setUser("joao.rocha");
        dados.setPassword("senha");

        String url = "https://auth-homolog.cwi.com.br/connect/token";

        response.setToken("token");

        ResponseEntity<LoginResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        Mockito.when(restTemplate.exchange(eq(url), eq(HttpMethod.POST), Mockito.any(), eq(LoginResponse.class)))
                .thenThrow(new RestClientException("Erro"));

        try{
            tested.logar(dados);
        }catch(ResponseStatusException e) {

            Mockito.verify(restTemplate).exchange(eq(url), eq(HttpMethod.POST), Mockito.any(), eq(LoginResponse.class));

            Assert.assertEquals("Algo deu errado ao fazer o login. Verifique as credenciais e tente novamente.", e.getReason());

            throw e;
        }
    }
}