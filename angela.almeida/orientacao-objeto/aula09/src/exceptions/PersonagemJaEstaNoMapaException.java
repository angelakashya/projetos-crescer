package exceptions;

public class PersonagemJaEstaNoMapaException extends Exception{

    public PersonagemJaEstaNoMapaException() {
        super("Este personagem já está no mapa!");
    }
}
