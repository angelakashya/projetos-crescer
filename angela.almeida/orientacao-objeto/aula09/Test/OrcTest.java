import org.junit.Assert;
import org.junit.Test;
import personagens.Orc;

public class OrcTest {
    @Test
    public void deveRetornarLetraMAoChamarOMetodoToString() {
        //arrange
        Orc orc = new Orc();
        String letraEsperada = "O";

        //act
        String letraRetornada = orc.toString();

        //arrange
        Assert.assertEquals(letraEsperada, letraRetornada);
    }

    @Test
    public void personagemDeveGrunirQuandoOMetodoGrunirForChamado() {
        //arrange
        Orc orc = new Orc();
        String grunidoEsperado = "Arrrggghhh";

        //act
        String grunidoFalado = orc.grunir();

        //assert
        Assert.assertEquals(grunidoEsperado, grunidoFalado);
    }
}
