import org.junit.Assert;
import org.junit.Test;
import personagens.Legolas;

public class LegolasTest {
    @Test
    public void deveExibirALetraAAoChamarOMetodoToString() {
        //arrange
        Legolas legolas = new Legolas();
        String letraEsperada = "L";

        //act
        String letraRetornada = legolas.toString();

        //assert
        Assert.assertEquals(letraEsperada, letraRetornada);

    }

    @Test
    public void personagemDeveFalarEmElficoQuandoOMetodoFalarEmElficoForChamado() {
        //arrange
        Legolas legolas = new Legolas();
        String fraseEsperada = "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";

        //act
        String fraseFalada = legolas.falarElfico();

        //assert
        Assert.assertEquals(fraseEsperada, fraseFalada);
    }


    @Test
    public void personagemDeveFalarSuaFraseQuandoOMetodoFalarForChamado() {
        //arrange
        Legolas legolas = new Legolas();
        String fraseEsperada = "They're taking the Hobbits to Isengard!";

        //act
        String fraseFalada = legolas.falar();

        //assert
        Assert.assertEquals(fraseEsperada, fraseFalada);
    }
}
