package armas;

import personagens.Demonio;

public class Pistola extends Arma {


    private static final int DANO = 5;
    private static final int MUNICAO = 30;

    public Pistola() {
        super(DANO, MUNICAO);
    }

}
