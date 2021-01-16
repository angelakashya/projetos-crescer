package br.com.cwi.crescer.api.controller.responsedto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;


@Data
public class LoginResponse {

    @JsonAlias({"access_token"})
    private String token;

}
