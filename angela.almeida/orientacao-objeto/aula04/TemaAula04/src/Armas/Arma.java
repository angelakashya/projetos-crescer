package Armas;

import Arena.Posicao;

public class Arma {
    private int danoArma;

    public Arma(int danoArma) {
        this.danoArma = danoArma;
    }

    public int getDanoArma() {
        return danoArma;
    }

    protected double calcularDistanciaEuclidiana(Posicao posicaoOrigem, Posicao posicaoDestino) {
        return Math.sqrt(Math.pow(posicaoDestino.getCoordenadaX() - posicaoOrigem.getCoordenadaX(), 2) + Math.pow(posicaoDestino.getCoordenadaY() - posicaoOrigem.getCoordenadaY(), 2));
    }

    public int calcularDano(Posicao posicaoOrigem, Posicao posicaoDestino) {

    return 0;
    }
}
