package personagens;

import classes.Guerreiro;
import enums.TipoPersonagem;
import racas.Humano;

public class Boromir extends Guerreiro implements Humano {
    private static final int FORCA = 7;
    private static final int AGILIDADE = 6;
    private static final int INTELIGENCIA = 3;
    private static final String LETRA = "B";
    private static final int DANO_AO_ENVELHECER = 2;
    private static final TipoPersonagem TIPO = TipoPersonagem.SOCIEDADE_DO_ANEL;

    public Boromir() {
        super(FORCA, AGILIDADE, INTELIGENCIA,40, LETRA, TIPO);
    }

    @Override
    public String toString() {
        return LETRA;
    }

    @Override
    public void envelhecer() {
        setConstituicao(getConstituicao() - DANO_AO_ENVELHECER);
    }

    @Override
    public String falar() {
       return "One does not simply walk into Mordor.";
    }
}
