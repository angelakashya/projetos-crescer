package megazord;

import org.junit.Assert;
import org.junit.Test;
import zords.*;

import static org.junit.Assert.*;

public class MegazordTankModeTest {

    @Test
    public void alturaDeveSerCalculadaCorretamente() {

        MegazordTankMode tank = new MegazordTankMode(
                new TyrannosaurusDinozord(),
                new PterodactylDinozord(),
                new MastodonDinozord(),
                new SabertoothTigerDinozord(),
                new TriceraptopsDinozord());

        int resultadoEsperado = 76;

        assertEquals(resultadoEsperado, tank.getAltura());
    }

    @Test
    public void comprimentoDeveSerCalculadoCorretamente() {
        MegazordTankMode tank = new MegazordTankMode(
                new TyrannosaurusDinozord(),
                new PterodactylDinozord(),
                new MastodonDinozord(),
                new SabertoothTigerDinozord(),
                new TriceraptopsDinozord());

        int comprimentoEsperado = 74;

        int comprimentoCalculado = tank.getComprimento();

        Assert.assertEquals(comprimentoEsperado, comprimentoCalculado);

    }

    @Test
    public void pesoDeveSerCalculado() {
        MegazordTankMode tank = new MegazordTankMode(
                new TyrannosaurusDinozord(),
                new PterodactylDinozord(),
                new MastodonDinozord(),
                new SabertoothTigerDinozord(),
                new TriceraptopsDinozord());

        int pesoEsperado = 570;
        int pesoCalculado = tank.getPeso();

        Assert.assertEquals(pesoEsperado, pesoCalculado);
    }

    @Test
    public void velocidadeDeveSerCalculada() {
        MegazordTankMode tank = new MegazordTankMode(
                new TyrannosaurusDinozord(),
                new PterodactylDinozord(),
                new MastodonDinozord(),
                new SabertoothTigerDinozord(),
                new TriceraptopsDinozord());

        int velocidadeEsperada = 580;
        int velocidadeCalculada = tank.getVelocidade();

        Assert.assertEquals(velocidadeEsperada, velocidadeCalculada);
    }

}