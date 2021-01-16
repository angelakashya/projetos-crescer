package personagens;

import classes.Mago;
import enums.TipoPersonagem;
import racas.Maia;

public class Saruman extends Mago implements Maia{

    private static final int FORCA = 2;
    private static final int AGILIDADE = 2;
    private static final int INTELIGENCIA = 9;
    private static final String LETRA = "S";
    private static final TipoPersonagem TIPO = TipoPersonagem.LEGIAO_DE_SAURON;

    public Saruman() {
        super(FORCA, AGILIDADE, INTELIGENCIA,70, LETRA, TIPO);
    }

    @Override
    public String toString() {
        return LETRA;
    }

    @Override
    public Saruman ressucitar() {
        if(getConstituicao() == 0)
            return new Saruman();
        else
            return null;
    }

    @Override
    public String falar() {
        return "Against the power of Mordor there can be no victory.";
    }

}
