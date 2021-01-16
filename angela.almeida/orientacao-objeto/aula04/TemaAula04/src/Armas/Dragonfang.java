package Armas;

import Arena.Posicao;

public class Dragonfang extends Arma {

    private static final int DANO = 30;

    public Dragonfang() {

        super(DANO);
    }

    @Override
    public int calcularDano(Posicao posicaoOrigem, Posicao posicaoDestino) {
        double distanciaEuclidiana = (int)calcularDistanciaEuclidiana(posicaoOrigem, posicaoDestino);

        if(distanciaEuclidiana < 5)
            return 0;
        else
           return getDanoArma() * 10;
    }
}
