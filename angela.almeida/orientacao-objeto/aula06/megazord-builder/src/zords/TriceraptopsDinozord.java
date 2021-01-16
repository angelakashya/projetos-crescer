package zords;

import megazord.parts.RodaDireita;

public class TriceraptopsDinozord extends Zord implements RodaDireita {

    private static final int COMPRIMENTO = 37;
    private static final int ALTURA = 11;
    private static final int PESO = 141;
    private static final int VELOCIDADE = 140;

    public TriceraptopsDinozord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}
