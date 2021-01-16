import org.junit.Assert;
import org.junit.Test;
import personagens.Goblim;

public class GoblimTest {
    @Test
    public void deveRetornarLetraMAoChamarOMetodoToString() {
        //arrange
        Goblim goblim = new Goblim();
        String letraEsperada = "M";

        //act
        String letraRetornada = goblim.toString();

        //arrange
        Assert.assertEquals(letraEsperada, letraRetornada);
    }

    @Test
    public void personagemDeveGrunirQuandoOMetodoGrunirForChamado() {
        //arrange
        Goblim goblim = new Goblim();
        String grunidoEsperado =  "Iiisshhhh";

        //act
        String grunidoFalado = goblim.grunir();

        //assert
        Assert.assertEquals(grunidoEsperado, grunidoFalado);
    }
}
