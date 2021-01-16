package exceptions;

public class NivelMuitoBaixoParaEvolucaoException extends Exception{

    public NivelMuitoBaixoParaEvolucaoException(int nivelAtual, int nivelEvolucao) {
        super(String.format("Este pokemon esta no nivel %d e só pode evoluir no %d", nivelAtual, nivelEvolucao));
    }
}
