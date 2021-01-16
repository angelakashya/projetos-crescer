package zords;

import megazord.parts.Peito;
import megazord.parts.Topo;

public class PterodactylDinozord extends Zord implements Peito, Topo {

    private static final int COMPRIMENTO = 21;
    private static final int ALTURA = 10;
    private static final int PESO = 84;
    private static final int VELOCIDADE = 3087;

    public PterodactylDinozord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}
