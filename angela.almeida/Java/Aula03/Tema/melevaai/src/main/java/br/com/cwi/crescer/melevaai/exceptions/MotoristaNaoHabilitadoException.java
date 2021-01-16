package br.com.cwi.crescer.melevaai.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MotoristaNaoHabilitadoException extends RuntimeException {
    public MotoristaNaoHabilitadoException() {

        super("Motorista não esta habilitado para esse tipo de Veiculo!");
    }
}

