package Trajetos;

public abstract class Trajeto {

    private final int dificuldade;

    protected Trajeto(int dificuldade) {
        this.dificuldade = dificuldade * 2;
    }

    public int getDificuldade() {
        return dificuldade;
    }
}
