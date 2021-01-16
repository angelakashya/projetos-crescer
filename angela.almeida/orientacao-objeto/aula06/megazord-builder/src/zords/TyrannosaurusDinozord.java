package zords;

import megazord.parts.Cabeca;
import megazord.parts.Centro;

public class TyrannosaurusDinozord extends Zord implements Centro, Cabeca {

    private static final int COMPRIMENTO = 45;
    private static final int ALTURA = 27;
    private static final int PESO = 96;
    private static final int VELOCIDADE = 120;

    public TyrannosaurusDinozord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}
