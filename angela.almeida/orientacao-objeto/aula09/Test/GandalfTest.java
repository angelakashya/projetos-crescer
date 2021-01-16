import org.junit.Assert;
import org.junit.Test;
import personagens.Gandalf;
import racas.Maia;

public class GandalfTest {
    @Test
    public void deveExibirALetraGAoChamarOMetodoToString() {
        //arrange
        Gandalf gandalf = new Gandalf();
        String letraEsperada = "G";

        //act
        String letraRetornada = gandalf.toString();

        //assert
        Assert.assertEquals(letraEsperada, letraRetornada);
    }

    @Test
    public void deveInstanciarUmNovoGandalfComACosntituicaoCompletaAoChamarOMetodoRessucitarSeAConstituicaoForZero() {
        //arrange
        Gandalf gandalf = new Gandalf();
        int constituicaoFinalEsperada = 80;

        //act
        gandalf.setConstituicao(0);
        Gandalf novoGandalf = gandalf.ressucitar();
        int constituicaoFinal = novoGandalf.getConstituicao();

        //assert
        Assert.assertEquals(constituicaoFinalEsperada, constituicaoFinal);
    }

    @Test
    public void naoDeveInstanciarUmNovoGandalfQuandoAConstituicaoForMaiorQueZero() {
        //arrange
        Gandalf gandalf = new Gandalf();
        Gandalf retornoEsperado = null;

        //act
        Gandalf retornoFinal = gandalf.ressucitar();

        //assert
        Assert.assertEquals(retornoEsperado, retornoFinal);
    }

    @Test
    public void personagemDeveFalarSuaFraseQuandoOMetodoFalarForChamado() {
        //arrange
        Gandalf gandalf = new Gandalf();
        String falaEsperada = "A Wizard is never late, nor is he early. He arrives precisely when he means to.";

        //act
        String falaFinal = gandalf.falar();

        //assert
        Assert.assertEquals(falaEsperada, falaFinal);
    }
}
