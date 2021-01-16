import org.junit.Test;

public class NinjaTest {
    @Test
    public void ninjaDevePerderPontosDeChacra() {
        Jutsu jutsu = new Jutsu(10, 10);
        Ninja ninja = new Ninja("Itachi", jutsu);
        int chakraFinalEsperado = 50;

        int chakraResultante = ninja.receberGolpe(50);


    }

}
