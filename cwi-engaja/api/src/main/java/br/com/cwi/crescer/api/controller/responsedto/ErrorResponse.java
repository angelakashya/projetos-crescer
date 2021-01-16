package br.com.cwi.crescer.api.controller.responsedto;

import lombok.Data;

@Data
public class ErrorResponse {

    private String message;
    private int status;

}
