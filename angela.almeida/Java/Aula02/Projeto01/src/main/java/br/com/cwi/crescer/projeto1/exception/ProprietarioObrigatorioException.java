package br.com.cwi.crescer.projeto1.exception;

public class ProprietarioObrigatorioException extends RuntimeException {

    public ProprietarioObrigatorioException() {
        super("O veiculo deve ter um proprietário!");
    }
}
