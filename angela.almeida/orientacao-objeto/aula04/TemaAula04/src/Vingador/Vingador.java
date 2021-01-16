package Vingador;

import Arena.Posicao;
import Armas.Arma;
import HabilidadesEspeciais.HabilidadeEspecial;

public class Vingador {

    private String nome;
    private int vida;
    private Arma arma;
    private HabilidadeEspecial habilidadeEspecial;
    private Posicao posicao;

    public Vingador(String nome, int vida, Arma arma, HabilidadeEspecial habilidadeEspecial, Posicao posicao) {
        this.nome = nome;
        this.vida = vida;
        this.arma = arma;
        this.habilidadeEspecial = habilidadeEspecial;
        this.posicao = posicao;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void atacar(Vingador adversario) {
        int danoTotal = Math.toIntExact(Math.round(arma.getDanoArma()  + (arma.getDanoArma() * habilidadeEspecial.getPercentualBonus())));
        adversario.setVida(danoTotal);

    }

    public Posicao getPosicao() {

        return this.posicao;
    }

    public String getNome() {

        return this.nome;
    }

    public int getVida() {
        return vida;
    }
}
