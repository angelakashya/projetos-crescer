package armas;

import personagens.Demonio;

public class BFG  extends Arma{

    private static final int MUNICAO = 5;

    BFG() {
        super(0, MUNICAO);
    }

    @Override
    public void atirar(Demonio demonio) {
        if (getMunicao() <= 0) return;

        demonio.levarTiro(demonio.getVida());
        decrementarMunicao();
    }
}
