package br.com.cwi.crescer.melevaai.exceptions;

public class MotoristaNaoHabilitadoException extends RuntimeException {
    public MotoristaNaoHabilitadoException() {

        super("Motorista não esta habilitado para esse tipo de Veiculo!");
    }
}

