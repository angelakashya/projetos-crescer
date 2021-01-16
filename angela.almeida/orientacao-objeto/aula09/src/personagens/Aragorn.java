package personagens;

import classes.Guerreiro;
import enums.TipoPersonagem;
import racas.Humano;

public class Aragorn extends Guerreiro implements Humano {

    private static final int FORCA = 10;
    private static final int AGILIDADE = 7;
    private static final int INTELIGENCIA = 6;
    private static final String LETRA = "A";
    private static final int DANO_AO_ENVELHECER = 1;
    private static final int CONSTITUICAO_INICIAL = 60;
    private static final TipoPersonagem TIPO = TipoPersonagem.SOCIEDADE_DO_ANEL;

    public Aragorn() {
        super(FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL,LETRA, TIPO);
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
        return "A day may come when the courage of men fails… but it is not THIS day.";
    }
}
