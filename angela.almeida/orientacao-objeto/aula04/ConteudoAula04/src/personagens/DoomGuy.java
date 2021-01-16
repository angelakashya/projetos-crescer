package personagens;

import armas.Arma;
import armas.BFG;
import armas.Doze;
import armas.Pistola;
import personagens.Demonio;

public class DoomGuy {

    private int vida = 100;
    private int armadura = 100;

    private Arma arma = new Pistola();

    public void atirar(Demonio demonio) {
        arma.atirar(demonio);
    }

    public void equiparArma(Arma arma) {
        this.arma = arma;
    }

    public void receberAtaque(int dano) {
        if (armadura > 0) {
            armadura -= dano;
        } else {
            vida -= dano;
        }
    }

}
