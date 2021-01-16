package zords;

import megazord.parts.Peito;

public class YellowBearNinjazord extends Zord implements Peito {

    private static final int COMPRIMENTO = 28;
    private static final int ALTURA = 30;
    private static final int PESO = 2000;
    private static final int VELOCIDADE = 70;

    public YellowBearNinjazord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}
