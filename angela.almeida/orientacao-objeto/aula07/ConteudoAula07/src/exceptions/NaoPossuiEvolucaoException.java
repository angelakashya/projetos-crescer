package exceptions;

public class NaoPossuiEvolucaoException extends Exception {

    public NaoPossuiEvolucaoException() {
        super("Este Pokemon não possui evolucao");
    }

}
