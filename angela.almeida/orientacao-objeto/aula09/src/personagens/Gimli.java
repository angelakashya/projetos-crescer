package personagens;

import classes.Guerreiro;
import enums.TipoPersonagem;
import racas.Anao;

public class Gimli extends Guerreiro implements Anao {

    private static final int FORCA = 9;
    private static final int AGILIDADE = 2;
    private static final int INTELIGENCIA = 4;
    private static final String LETRA = "I";
    private int vezesQueBebeu;
    private static final TipoPersonagem TIPO = TipoPersonagem.SOCIEDADE_DO_ANEL;

    public Gimli() {
        super(FORCA, AGILIDADE, INTELIGENCIA, 60, LETRA, TIPO);
    }

    public int getVezesQueBebeu() {
        return vezesQueBebeu;
    }

    @Override
    public String toString() {
        return LETRA;
    }

    @Override
    public void beber() {
        vezesQueBebeu++;
    }

    @Override
    public String falar() {
        if (vezesQueBebeu >= 3)
            return "What did I say? He can't hold his liquor!";
        else
            return "Let them come. There is one Dwarf yet in Moria who still draws breath.";
    }
}
