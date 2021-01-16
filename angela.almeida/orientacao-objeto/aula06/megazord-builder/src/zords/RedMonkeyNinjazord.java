package zords;

import megazord.parts.PernaDireita;

public class RedMonkeyNinjazord extends Zord implements PernaDireita {

    private static final int COMPRIMENTO = 20;
    private static final int ALTURA = 31;
    private static final int PESO = 1300;
    private static final int VELOCIDADE = 60;

    public RedMonkeyNinjazord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}
