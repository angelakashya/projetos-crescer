package Peças;

import Trajetos.Trajeto;

public abstract class Peca {

    private int qualidade;
    private int velocidadeDeDesgaste;

    public Peca(int qualidade, int velocidadeDeDesgaste) {
        this.qualidade = qualidade;
        this.velocidadeDeDesgaste = velocidadeDeDesgaste;
    }

    public int usarNoTrajeto(Trajeto trajeto) {

      for(int i = 0; i < qualidade; i++){
          qualidade -= trajeto.getDificuldade() * velocidadeDeDesgaste;
          if(qualidade >= 0)
              qualidade = 0;
      }
      return qualidade;
    }

    public int getQualidade() {
        return qualidade;
    }
}
