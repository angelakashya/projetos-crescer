package Peças;

public class Motor extends Peca {

   private int qualidade;
   private static final int VELOCIDADE_DE_DESGASTE = 1;

    public Motor(int qualidade) {
        super(qualidade, VELOCIDADE_DE_DESGASTE);
    }
}
