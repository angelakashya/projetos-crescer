package br.com.cwi.crescer.projeto1.exception;

public class MotoristaComCNHVencidaException extends RuntimeException {

    public MotoristaComCNHVencidaException() {
        super("A CNH do motorista está vencida!");
    }
}
