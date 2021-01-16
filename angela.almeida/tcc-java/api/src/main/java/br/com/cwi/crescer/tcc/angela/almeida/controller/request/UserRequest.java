package br.com.cwi.crescer.tcc.angela.almeida.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRequest {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private List<String> roles;

    public UserRequest(String email, String firstName, String lastName, String password, List<String> roles) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.roles = roles;
    }
}
