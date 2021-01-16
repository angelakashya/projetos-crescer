package megazord;

import megazord.parts.*;
import megazord.parts.ZordPart;

public class MegazordBattleMode{
    Cabeca cabeca;
    Peito peito;
    Bracos bracos;
    PernaEsquerda pernaEsquerda;
    PernaDireita pernaDireita;

    public MegazordBattleMode(Cabeca cabeca, Peito peito, Bracos bracos, PernaEsquerda pernaEsquerda, PernaDireita pernaDireita) {
        this.cabeca = cabeca;
        this.peito = peito;
        this.bracos = bracos;
        this.pernaEsquerda = pernaEsquerda;
        this.pernaDireita = pernaDireita;
    }

    public int getComprimento() {
        return (pernaEsquerda.getComprimento() + pernaDireita.getComprimento()) / 2;
    }

    public int getAltura() {
        return cabeca.getAltura() +
                peito.getAltura() +
                (pernaEsquerda.getAltura() + pernaDireita.getAltura())/ 2;
    }

    public int getPeso() {
        return cabeca.getPeso() +
                peito.getPeso() +
                bracos.getPeso() +
                pernaEsquerda.getPeso() +
                pernaDireita.getPeso();
    }

    public int getVelocidade() {
        return (pernaEsquerda.getVelocidade() + pernaDireita.getVelocidade()) * 2;
    }
}
