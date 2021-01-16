package br.com.cwi.crescer.projeto1.exception;

public class IdadeMininaInvalidaException extends RuntimeException{
    public IdadeMininaInvalidaException() {
        super("Idade Minima Invalida");
    }
}
