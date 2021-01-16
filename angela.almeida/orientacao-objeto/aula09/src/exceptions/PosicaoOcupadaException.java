package exceptions;

public class PosicaoOcupadaException extends Exception {

    public PosicaoOcupadaException() {
        super("Posição já está ocupada");
    }
}
