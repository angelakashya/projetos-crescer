package br.com.cwi.crescer.api.controller.requestdto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class LoginRequest {

    @NotEmpty
    private String user;

    @NotEmpty
    private String password;
}
