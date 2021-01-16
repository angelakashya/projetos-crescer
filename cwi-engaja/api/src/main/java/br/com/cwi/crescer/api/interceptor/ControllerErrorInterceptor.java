package br.com.cwi.crescer.api.interceptor;

import br.com.cwi.crescer.api.controller.responsedto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestControllerAdvice
public class ControllerErrorInterceptor {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {

        ErrorResponse response = new ErrorResponse();
        response.setMessage("Desculpe, ocorreu um erro inesperado...");
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        log.error("Ocorreu um erro...", exception);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(ResponseStatusException exception) {

        ErrorResponse response = new ErrorResponse();
        response.setMessage(exception.getReason());
        response.setStatus(exception.getStatus().value());

        log.error("Ocorreu um erro", exception);

        return new ResponseEntity<>(response, exception.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(DataIntegrityViolationException exception) {

        ErrorResponse response = new ErrorResponse();
        if(exception.getMessage().contains("UK_TITULO_DESAFIO"))
            response.setMessage("Já existe um desafio com esse título.");
        else
            response.setMessage("Ocorreu um erro inesperado.");
        response.setStatus(HttpStatus.BAD_REQUEST.value());

        log.error("Ocorreu um erro:", exception);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}

