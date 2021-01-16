package br.com.cwi.crescer.melevaai.exceptions;

public class ProprietarioObrigatorioException extends RuntimeException {

    public ProprietarioObrigatorioException() {
        super("O veiculo deve ter um proprietário!");
    }
}

