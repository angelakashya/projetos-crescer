import org.junit.Assert;
import org.junit.Test;
import personagens.Gimli;

public class GimliTest {
    @Test
    public void deveExibirALetraIAoChamarOMetodoToString() {
        //arrange
        Gimli gimli = new Gimli();
        String letraEsperada = "I";

        //act
        String letraRetornada = gimli.toString();

        //assert
        Assert.assertEquals(letraEsperada, letraRetornada);
    }

    @Test
    public void deveContabilizarOQuantoBebeuCadaVezQueChamarOMetodoBeber() {
        //arrange
        Gimli gimli = new Gimli();
        int vezesQueBebeuEsperadas = 1;

        //act
        gimli.beber();
        int vezesQueBebeuFinal = gimli.getVezesQueBebeu();

        //assert
        Assert.assertEquals(vezesQueBebeuEsperadas, vezesQueBebeuFinal);
    }

    @Test
    public void deveFalarBebadoQuandoBeberMaisDeTresVezes() {
        //arrange
        Gimli gimli = new Gimli();
        String falaEsperada = "What did I say? He can't hold his liquor!";

        //act
        gimli.beber();
        gimli.beber();
        gimli.beber();
        String falaRetornada = gimli.falar();

        //assert
        Assert.assertEquals(falaEsperada, falaRetornada);
    }

    @Test
    public void deveFalarSobrioQuandoBeberMenosDeTresVezes() {
        //arrange
        Gimli gimli = new Gimli();
        String falaEsperada = "Let them come. There is one Dwarf yet in Moria who still draws breath.";

        //act
        gimli.beber();
        String falaRetornada = gimli.falar();

        //assert
        Assert.assertEquals(falaEsperada, falaRetornada);
    }
}
