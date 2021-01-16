package personagens;

import classes.Guerreiro;
import enums.TipoPersonagem;
import racas.Humano;
import racas.Monstro;

public class Urukhai extends Guerreiro implements Humano, Monstro {

    private static final int FORCA = 8;
    private static final int AGILIDADE = 6;
    private static final int INTELIGENCIA = 3;
    private static final String LETRA = "U";
    private static final int DANO_AO_ENVELHECER = 2;
    private static final TipoPersonagem TIPO = TipoPersonagem.LEGIAO_DE_SAURON;

    public Urukhai() {
        super(FORCA, AGILIDADE, INTELIGENCIA,45, LETRA, TIPO);
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
        return "Looks like meat's back on the menu boys!";
    }

    @Override
    public String grunir() {
        return "Uuurrrrrr";
    }
}
