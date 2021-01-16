import org.junit.Assert;
import org.junit.Test;
import personagens.Aragorn;
import personagens.Boromir;

public class BoromirTest {
    @Test
    public void deveExibirALetraBAoChamarOMetodoToString() {
        //arrange
        Boromir boromir = new Boromir();
        String letraEsperada = "B";

        //act
        String letraRetornada = boromir.getLetra();

        //assert
        Assert.assertEquals(letraEsperada, letraRetornada);
    }

    @Test
    public void devePerderDoisPontosDeConstituicaoCadaVezQueChamarOMetodoEnvelhecer() {
        //arrange
        Boromir boromir = new Boromir();
        int constituicaoEsperada = 38;

        //act
        boromir.envelhecer();
        int constituicaoFinal = boromir.getConstituicao();

        //assert
        Assert.assertEquals(constituicaoEsperada, constituicaoFinal);
    }

    @Test
    public void personagemDeveFalarSuaFraseQuandoOMetodoFalarForChamado() {
        //arrange
        Boromir boromir = new Boromir();
        String fraseEsperada = "One does not simply walk into Mordor.";

        //act
        String fraseFalada = boromir.falar();

        //assert
        Assert.assertEquals(fraseEsperada, fraseFalada);
    }
}
