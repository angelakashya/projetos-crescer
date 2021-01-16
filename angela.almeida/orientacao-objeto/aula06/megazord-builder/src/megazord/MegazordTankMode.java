package megazord;

import megazord.parts.*;

public class MegazordTankMode {

    private Centro centro;
    private Topo topo;
    private Canhao canhao;
    private RodaEsquerda rodaEsquerda;
    private RodaDireita rodaDireita;

    public MegazordTankMode(Centro centro, Topo topo, Canhao canhao, RodaEsquerda rodaEsquerda, RodaDireita rodaDireita) {
        this.centro = centro;
        this.topo = topo;
        this.canhao = canhao;
        this.rodaEsquerda = rodaEsquerda;
        this.rodaDireita = rodaDireita;
    }

    public int getAltura() {
        return topo.getAltura() +
                centro.getAltura() +
                canhao.getAltura() +
                rodaDireita.getAltura() +
                rodaEsquerda.getAltura();
    }

    public int getComprimento() {
        return rodaEsquerda.getComprimento() +
                rodaDireita.getComprimento();

    }

    public int getPeso() {
        return centro.getPeso() +
                topo.getPeso() +
                canhao.getPeso() +
                rodaEsquerda.getPeso() +
                rodaDireita.getPeso();
    }

    public int getVelocidade() {
        return (rodaEsquerda.getVelocidade() + rodaDireita.getVelocidade()) * 2;
    }
}
