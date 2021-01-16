package zords;

import megazord.parts.Canhao;
import megazord.parts.PernaDireita;
import megazord.parts.PernaEsquerda;

public class MastodonDinozord extends Zord implements Canhao, PernaEsquerda {

    private static final int COMPRIMENTO = 25;
    private static final int ALTURA = 15;
    private static final int PESO = 108;
    private static final int VELOCIDADE = 120;

    public MastodonDinozord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}
