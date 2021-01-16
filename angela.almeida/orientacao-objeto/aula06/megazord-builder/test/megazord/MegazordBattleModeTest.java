package megazord;

import megazord.parts.Peito;
import megazord.parts.Topo;
import org.junit.Assert;
import org.junit.Test;
import zords.*;

public class MegazordBattleModeTest {

    @Test
    public void comprimentoDeveSerCalculado() {
        MegazordBattleMode battle = new MegazordBattleMode(
                new PinkCreaneNinjazord(),
                new YellowBearNinjazord(),
                new BlackFrogNinjazord(),
                new BlueWolfNinjazord(),
                new RedMonkeyNinjazord());

        int comprimentoEsperado = 26;
        int comprimentoCalculado = battle.getComprimento();

        Assert.assertEquals(comprimentoEsperado, comprimentoCalculado);
    }

    @Test
    public void alturaDeveSerCalculada() {
        MegazordBattleMode battle = new MegazordBattleMode(
                new PinkCreaneNinjazord(),
                new YellowBearNinjazord(),
                new BlackFrogNinjazord(),
                new BlueWolfNinjazord(),
                new RedMonkeyNinjazord());

        int alturaEsperada = 80;
        int alturaCalculada = battle.getAltura();

        Assert.assertEquals(alturaEsperada, alturaCalculada);
    }

    @Test
    public void pesoDeveSerCalculado() {
        MegazordBattleMode battle = new MegazordBattleMode(
                new PinkCreaneNinjazord(),
                new YellowBearNinjazord(),
                new BlackFrogNinjazord(),
                new BlueWolfNinjazord(),
                new RedMonkeyNinjazord());

        int pesoEsperado = 7200;
        int pesoCalculado = battle.getPeso();

        Assert.assertEquals(pesoEsperado, pesoCalculado);
    }

    @Test
    public void velocidadeDeveSerCalculada() {
        MegazordBattleMode battle = new MegazordBattleMode(
                new PinkCreaneNinjazord(),
                new YellowBearNinjazord(),
                new BlackFrogNinjazord(),
                new BlueWolfNinjazord(),
                new RedMonkeyNinjazord());

        int velocidadeEsperada = 300;
        int velocidadeCalculada = battle.getVelocidade();

        Assert.assertEquals(velocidadeEsperada, velocidadeCalculada);
    }
}