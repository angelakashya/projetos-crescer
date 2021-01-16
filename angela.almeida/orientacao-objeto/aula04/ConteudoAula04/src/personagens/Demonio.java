package personagens;

public class Demonio {

    private static final int DANO_PADRAO = 20;
    private int vida = 100;

    public void atacar(DoomGuy doomGuy) {
        doomGuy.receberAtaque(DANO_PADRAO);
        this.vida += 10;
    }

    public void levarTiro(int dano) {
        vida -= dano;
    }

    public int getVida() {
        return vida;
    }
}
