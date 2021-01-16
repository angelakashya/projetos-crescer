import org.junit.Assert;
import org.junit.Test;
import personagens.Saruman;

public class SarumanTest {
    @Test
    public void deveExibirALetraGAoChamarOMetodoToString() {
        //arrange
        Saruman saruman = new Saruman();
        String letraEsperada = "S";

        //act
        String letraRetornada = saruman.toString();

        //assert
        Assert.assertEquals(letraEsperada, letraRetornada);
    }

    @Test
    public void deveInstanciarUmNovoGandalfComACosntituicaoCompletaAoChamarOMetodoRessucitarSeAConstituicaoForZero() {
        //arrange
        Saruman saruman = new Saruman();
        int constituicaoFinalEsperada = 70;

        //act
        saruman.setConstituicao(0);
        Saruman novoSaruman = saruman.ressucitar();
        int constituicaoFinal = novoSaruman.getConstituicao();

        //assert
        Assert.assertEquals(constituicaoFinalEsperada, constituicaoFinal);
    }

    @Test
    public void naoDeveInstanciarUmNovoGandalfQuandoAConstituicaoForMaiorQueZero() {
        //arrange
        Saruman saruman = new Saruman();
        Saruman retornoEsperado = null;

        //act
        Saruman retornoFinal = saruman.ressucitar();

        //assert
        Assert.assertEquals(retornoEsperado, retornoFinal);
    }

    @Test
    public void personagemDeveFalarSuaFraseQuandoOMetodoFalarForChamado() {
        //arrange
        Saruman saruman = new Saruman();
        String falaEsperada = "Against the power of Mordor there can be no victory.";

        //act
        String falaFinal = saruman.falar();

        //assert
        Assert.assertEquals(falaEsperada, falaFinal);
    }
}
