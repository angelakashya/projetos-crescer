package zords;

import megazord.parts.Bracos;

public class BlackFrogNinjazord extends Zord implements Bracos {

    private static final int COMPRIMENTO = 20;
    private static final int ALTURA = 31;
    private static final int PESO = 2000;
    private static final int VELOCIDADE = 120;

    public BlackFrogNinjazord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}
