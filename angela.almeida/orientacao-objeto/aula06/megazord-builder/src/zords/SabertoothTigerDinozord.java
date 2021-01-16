package zords;

import megazord.parts.RodaEsquerda;

public class SabertoothTigerDinozord extends Zord implements RodaEsquerda {

    private static final int COMPRIMENTO = 37;
    private static final int ALTURA = 13;
    private static final int PESO = 141;
    private static final int VELOCIDADE = 150;

    public SabertoothTigerDinozord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}
