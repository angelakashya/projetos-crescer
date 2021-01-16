import org.junit.Assert;
import org.junit.Test;
import personagens.Boromir;
import personagens.Urukhai;

public class UrukhaiTest {
    @Test
    public void deveRetornarLetraUAoChamarOMetodoToString() {
        //arrange
        Urukhai urukhai = new Urukhai();
        String letraEsperada = "U";

        //act
        String letraRetornada = urukhai.toString();

        //arrange
        Assert.assertEquals(letraEsperada, letraRetornada);
    }

    @Test
    public void devePerderDoisPontosDeConstituicaoCadaVezQueChamarOMetodoEnvelhecer() {
        //arrange
        Urukhai urukhai = new Urukhai();
        int constituicaoEsperada = 41;

        //act
        urukhai.envelhecer();
        urukhai.envelhecer();
        int constituicaoFinal = urukhai.getConstituicao();

        //assert
        Assert.assertEquals(constituicaoEsperada, constituicaoFinal);
    }

    @Test
    public void personagemDeveFalarSuaFraseQuandoOMetodoFalarForChamado() {
        //arrange
        Urukhai urukhai = new Urukhai();
        String fraseEsperada = "Looks like meat's back on the menu boys!";

        //act
        String fraseFalada = urukhai.falar();

        //assert
        Assert.assertEquals(fraseEsperada, fraseFalada);
    }

    @Test
    public void personagemDeveGrunirQuandoOMetodoGrunirForChamado() {
        //arrange
        Urukhai urukhai = new Urukhai();
        String grunidoEsperado =  "Uuurrrrrr";

        //act
        String grunidoFalado = urukhai.grunir();

        //assert
        Assert.assertEquals(grunidoEsperado, grunidoFalado);
    }
}
