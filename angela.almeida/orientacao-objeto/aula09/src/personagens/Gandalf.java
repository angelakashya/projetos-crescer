package personagens;

import classes.Mago;
import enums.TipoPersonagem;
import racas.Maia;

public class Gandalf extends Mago implements Maia {
    private static final int FORCA = 2;
    private static final int AGILIDADE = 3;
    private static final int INTELIGENCIA = 10;
    private static final String LETRA = "G";
    private static final TipoPersonagem TIPO = TipoPersonagem.SOCIEDADE_DO_ANEL;

    public Gandalf() {
        super(FORCA, AGILIDADE, INTELIGENCIA, 80, LETRA, TIPO);
    }

    @Override
    public String toString() {
        return LETRA;
    }

    @Override
    public Gandalf ressucitar() {
        if (getConstituicao() == 0)
            return new Gandalf();
        else
            return null;
    }

    @Override
    public String falar() {
        return "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
    }

}
