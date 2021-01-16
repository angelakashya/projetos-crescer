package br.com.cwi.crescer.api.security.cwi;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CWIUserResponse {

    private Boolean active;

    @JsonAlias({"http://schemas.xmlsoap.org/ws/2005/05/identity/claims/nameidentifier"})
    private String usuario;
}
