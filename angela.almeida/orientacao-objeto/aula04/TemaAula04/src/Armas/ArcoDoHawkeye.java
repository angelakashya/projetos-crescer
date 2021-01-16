package Armas;

import Arena.Posicao;

public class ArcoDoHawkeye extends Arma {

    private static int DANO = 10;
    public ArcoDoHawkeye() {

        super(DANO);
    }

    @Override
    public int calcularDano(Posicao posicaoOrigem, Posicao posicaoDestino) {
        int distanciaEuclidiana = (int) calcularDistanciaEuclidiana(posicaoOrigem, posicaoDestino);

        if(distanciaEuclidiana < 100)
            return 0;
        else if(distanciaEuclidiana >= 100 || distanciaEuclidiana == 500)
            return getDanoArma() * (distanciaEuclidiana / 100);
        else
           return getDanoArma() * 10;

    }
}
