package zords;

import megazord.parts.PernaEsquerda;

public class BlueWolfNinjazord extends Zord implements PernaEsquerda {

    private static final int COMPRIMENTO = 33;
    private static final int ALTURA = 39;
    private static final int PESO = 1300;
    private static final int VELOCIDADE = 90;

    public BlueWolfNinjazord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}