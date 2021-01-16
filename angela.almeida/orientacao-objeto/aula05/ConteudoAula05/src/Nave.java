import Recursos.Recurso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Nave {

    private static final int AVANCO = 1;

    private static final int RECUO = -1;

    public static final int GASTO_DE_COMBUSTIVEL = 3;

    private static final int POSICAO_INCIAL = 0;

    private int posicao;

    private int quantidadeDeCombustivel;

    private final List<Recurso> recursosColetados;

    public Nave(int quantidadeDeCombustivel) {
        this.quantidadeDeCombustivel = quantidadeDeCombustivel;
        this.posicao = POSICAO_INCIAL;
        this.recursosColetados = new ArrayList<>();
    }

    public int getPosicao() {
        return posicao;
    }

    public int getQuantidadeDeCombustivel() {
        return quantidadeDeCombustivel;
    }

    public List<Recurso> getRecursosColetados() {
        return recursosColetados;
    }

    public List<Recurso> explorar(Planeta planeta) {
        this.viajar(planeta.getPosicao(), AVANCO);

        if(this.posicao != planeta.getPosicao())
            return this.recursosColetados;

        this.recursosColetados.addAll(planeta.getRecursos());

        this.viajar(POSICAO_INCIAL, RECUO);

        return this.recursosColetados;
    }

    public List<Recurso> explorar(List<Planeta> planetas, Comparator comparador) {
        Collections.sort(planetas, comparador);

        for(Planeta planeta : planetas) {
            this.viajar(planeta.getPosicao(), planeta.getPosicao() > this.posicao ? AVANCO : RECUO);

            if(this.posicao != planeta.getPosicao())
                return this.recursosColetados;

            this.recursosColetados.addAll(planeta.getRecursos());
        }

        this.viajar(POSICAO_INCIAL, RECUO);

        return this.recursosColetados;
    }

    private void viajar(int posicaoDesejada, int passo) {
        while(this.posicao != posicaoDesejada) {
            if(GASTO_DE_COMBUSTIVEL > this.quantidadeDeCombustivel)
                return;

            this.posicao += passo;
            this.quantidadeDeCombustivel -= GASTO_DE_COMBUSTIVEL;
        }
    }
}
