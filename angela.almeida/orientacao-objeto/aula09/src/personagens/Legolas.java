package personagens;

import classes.Arqueiro;
import enums.TipoPersonagem;
import racas.Elfo;

public class Legolas extends Arqueiro implements Elfo {

    private static final int FORCA = 5;
    private static final int AGILIDADE = 10;
    private static final int INTELIGENCIA = 6;
    private static final String LETRA = "L";
    private static final TipoPersonagem TIPO = TipoPersonagem.SOCIEDADE_DO_ANEL;

    public Legolas() {
        super(FORCA, AGILIDADE, INTELIGENCIA,80, LETRA, TIPO);
    }

    @Override
    public String toString() {
        return LETRA;
    }

    @Override
    public String falarElfico() {
        return "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";
    }

    @Override
    public String falar() {
        return "They're taking the Hobbits to Isengard!";
    }
}
