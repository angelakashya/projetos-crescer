package zords;

import megazord.parts.Cabeca;

public class PinkCreaneNinjazord extends Zord implements Cabeca {

    private static final int COMPRIMENTO = 21;
    private static final int ALTURA = 15;
    private static final int PESO = 600;
    private static final int VELOCIDADE = 2469;

    public PinkCreaneNinjazord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}
