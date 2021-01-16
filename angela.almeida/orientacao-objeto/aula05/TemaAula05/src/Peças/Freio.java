package Peças;

public class Freio extends Peca {

    private int qualidade;
    private static final int VELOCIDADE_DE_DESGASTE = 2;

    public Freio(int qualidade) {
        super(qualidade, VELOCIDADE_DE_DESGASTE);
    }
}
