import org.junit.Assert;
import org.junit.Test;
import personagens.Aragorn;

public class AragornTest {
    @Test
    public void deveExibirALetraAAoChamarOMetodoToString() {
        //arrange
        Aragorn aragorn = new Aragorn();
        String letraEsperada = "A";

        //act
        String letraRetornada = aragorn.toString();

        //assert
        Assert.assertEquals(letraEsperada, letraRetornada);

    }

    @Test
    public void devePerderUmPontoDeConstituicaoCadaVezQueChamarOMetodoEnvelhecer() {
        //arrange
        Aragorn aragorn = new Aragorn();
        int constituicaoEsperada = 59;

        //act
        aragorn.envelhecer();
        int constituicaoFinal = aragorn.getConstituicao();

        //assert
        Assert.assertEquals(constituicaoEsperada, constituicaoFinal);
    }

    @Test
    public void personagemDeveFalarSuaFraseQuandoOMetodoFalarForChamado() {
        //arrange
        Aragorn aragorn = new Aragorn();
        String fraseEsperada = "A day may come when the courage of men fails… but it is not THIS day.";

        //act
        String fraseFalada = aragorn.falar();

        //assert
        Assert.assertEquals(fraseEsperada, fraseFalada);
    }
}
