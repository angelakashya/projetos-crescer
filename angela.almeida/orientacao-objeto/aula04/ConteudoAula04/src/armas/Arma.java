package armas;

import personagens.Demonio;

public class Arma {
    private int dano;
    private int municao;

    public Arma(int dano, int municao){
        this.dano = dano;
        this.municao = municao;
    }

    public void atirar(Demonio demonio) {
        if(municao <= 0) return;


        demonio.levarTiro(dano);
        decrementarMunicao();
    }

    protected void incrementarDano(int incremento) {
        this.dano += incremento;
    }

    protected void decrementarMunicao() {
        this.municao -= 1;
    }

    protected int getMunicao() {
        return municao;
    }
}
