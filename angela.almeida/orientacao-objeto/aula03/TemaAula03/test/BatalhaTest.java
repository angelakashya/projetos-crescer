import jdk.nashorn.internal.objects.NativeInt8Array;
import org.junit.Assert;
import org.junit.Test;

public class BatalhaTest {
    @Test
    public void testLutar(){
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Naruto", jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(5, 8);
        Ninja ninjaDois = new Ninja("Gaara", jutsuNinjaDois);

        Batalha batalha = new Batalha();

        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame(ninjaUm, ninjaVencedor);
    }

    @Test
    public void ninjaUmDeveGanharPorSerOItachi() {
        Jutsu jutsuNinjaUm = new Jutsu(10, 10);
        Ninja ninjaUm = new Ninja("Itachi", jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(10, 10);
        Ninja ninjaDois = new Ninja("Madara", jutsuNinjaDois);

        Ninja ninjaEsperadoComoVencedor = ninjaUm;

        Batalha batalha = new Batalha();

        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame(ninjaEsperadoComoVencedor, ninjaVencedor);
    }

    @Test
    public void empatouEONinjaUmDeveGanhar() {
        Jutsu jutsuNinjaUm = new Jutsu(10, 10);
        Ninja ninjaUm = new Ninja("Rock Lee", jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(10, 10);
        Ninja ninjaDois = new Ninja("Gaara", jutsuNinjaDois);

        Ninja ninjaEsperadoComoVencedor = ninjaUm;

        Batalha batalha = new Batalha();

        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame(ninjaEsperadoComoVencedor, ninjaVencedor);
    }

    @Test
    public void ninjaUmDeveGanhar() {
        Jutsu jutsuNinjaUm = new Jutsu(10, 10);
        Ninja ninjaUm = new Ninja("Neji", jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(7, 8);
        Ninja ninjaDois = new Ninja("Hinata", jutsuNinjaDois);

        Ninja ninjaEsperadoComoVencedor = ninjaUm;

        Batalha batalha = new Batalha();

        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame(ninjaEsperadoComoVencedor, ninjaVencedor);
    }

    @Test
    public void ninjaDoisDeveGanhar() {
        Jutsu jutsuNinjaUm = new Jutsu(7, 5);
        Ninja ninjaUm = new Ninja("Ino", jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(10, 10);
        Ninja ninjaDois = new Ninja("Sakura", jutsuNinjaDois);

        Ninja ninjaEsperadoComoVencedor = ninjaDois;

        Batalha batalha = new Batalha();

        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame(ninjaEsperadoComoVencedor, ninjaVencedor);
    }

    @Test
    public void ninjaDoisDeveGanharPorSerOItachi() {
        Jutsu jutsuNinjaUm = new Jutsu(10, 10);
        Ninja ninjaUm = new Ninja("Madara", jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(10, 10);
        Ninja ninjaDois = new Ninja("Itachi", jutsuNinjaDois);

        Ninja ninjaEsperadoComoVencedor = ninjaDois;

        Batalha batalha = new Batalha();

        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame(ninjaEsperadoComoVencedor, ninjaVencedor);
    }
}
