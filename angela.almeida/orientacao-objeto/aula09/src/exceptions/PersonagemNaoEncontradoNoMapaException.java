package exceptions;

public class PersonagemNaoEncontradoNoMapaException extends Exception{

    public PersonagemNaoEncontradoNoMapaException() {
        super("Personagem não encontrado no mapa");
    }
}
