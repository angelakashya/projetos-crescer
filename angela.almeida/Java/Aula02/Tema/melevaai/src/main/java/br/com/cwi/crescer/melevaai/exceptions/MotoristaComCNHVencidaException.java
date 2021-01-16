package br.com.cwi.crescer.melevaai.exceptions;

public class MotoristaComCNHVencidaException extends RuntimeException {

    public MotoristaComCNHVencidaException() {
        super("A CNH do motorista está vencida!");
    }
}

