package personagens;

import classes.Arqueiro;
import enums.TipoPersonagem;
import racas.Monstro;

public class Goblim extends Arqueiro implements Monstro {

    private static final int FORCA = 3;
    private static final int AGILIDADE = 6;
    private static final int INTELIGENCIA = 1;
    private static final String LETRA = "M";
    private static final TipoPersonagem TIPO = TipoPersonagem.LEGIAO_DE_SAURON;

    public Goblim() {
        super(FORCA, AGILIDADE, INTELIGENCIA,20, LETRA, TIPO);
    }

    @Override
    public String toString() {
        return LETRA;
    }

    @Override
    public String grunir() {
        return "Iiisshhhh";
    }
}
