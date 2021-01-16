package personagens;

import classes.Guerreiro;
import enums.TipoPersonagem;
import racas.Monstro;

    public class Orc extends Guerreiro implements Monstro {

    private static final int FORCA = 7;
    private static final int AGILIDADE = 4;
    private static final int INTELIGENCIA = 1;
    private static final String LETRA = "O";
    private static final TipoPersonagem TIPO = TipoPersonagem.LEGIAO_DE_SAURON;

    public Orc() {
        super(FORCA, AGILIDADE, INTELIGENCIA,30, LETRA, TIPO);
    }

    @Override
    public String toString() {
        return LETRA;
    }

    @Override
    public String grunir() {
        return "Arrrggghhh";
    }
}
