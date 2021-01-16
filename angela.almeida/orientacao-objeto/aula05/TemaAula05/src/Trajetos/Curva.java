package Trajetos;

public class Curva extends Trajeto {

    private int dificuldade;
    private static final int MODIFICADOR = 2;

    public Curva(int dificuldade) {

        super(dificuldade * MODIFICADOR);
    }

}
