package br.com.cwi.crescer.projeto1.exception;

public class MotoristaNaoHabilitadoException extends RuntimeException {
    public MotoristaNaoHabilitadoException() {

        super("Motorista não esta habilitado para esse tipo de Veiculo!");
    }
}
