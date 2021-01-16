import armas.Doze;
import org.junit.Assert;
import org.junit.Test;
import personagens.Demonio;
import personagens.DoomGuy;

public class TesteBase {
    @Test
    public void testeBase() {
        DoomGuy doomGuy = new DoomGuy();
        Demonio demonio = new Demonio();

        demonio.atacar(doomGuy);
        demonio.atacar(doomGuy);

        doomGuy.atirar(demonio);

        doomGuy.equiparArma(new Doze());

        doomGuy.atirar(demonio);
        doomGuy.atirar(demonio);

        Assert.assertEquals(90, demonio.getVida());
    }
}
