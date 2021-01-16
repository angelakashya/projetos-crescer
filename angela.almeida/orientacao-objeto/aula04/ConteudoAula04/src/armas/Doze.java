package armas;

import personagens.Demonio;

public class Doze extends Arma {

    private static final int INCREMENTO = 5;
    private static final int DANO = 10;
    private static final int MUNICAO = 15;

    public Doze() {
        super(DANO, MUNICAO);
    }

    @Override
    public void atirar(Demonio demonio) {
        super.atirar(demonio);
        incrementarDano(INCREMENTO);
    }
}

