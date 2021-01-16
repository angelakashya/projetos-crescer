package Arena;

import Vingador.Vingador;

public class Arena {
    private int largura;
    private int profundidade;

    public Arena(int largura, int profundidade) {
        this.largura = largura;
        this.profundidade = profundidade;
    }

    private boolean Empatou(Vingador vingador) {
        if(vingador.getPosicao().getCoordenadaX() < 1 || vingador.getPosicao().getCoordenadaX() > largura) {
            return true;
        } else if(vingador.getPosicao().getCoordenadaY() < 1 || vingador.getPosicao().getCoordenadaY() > profundidade) {
            return true;
        }
        else {
            return false;
        }
    }

    public String batalhar(Vingador primeiro, Vingador segundo) {
        primeiro.atacar(segundo);
        segundo.atacar(primeiro);
        primeiro.atacar(segundo);

        if(Empatou(primeiro) && Empatou(segundo)) {
            return "EMPATE";
        } else if(Empatou(segundo)) {
            return primeiro.getNome();
        } else if(Empatou(primeiro)) {
            return segundo.getNome();
        }else if (primeiro.getVida() < segundo.getVida()) {
            return primeiro.getNome();
        } else
            return segundo.getNome();

    }
}
