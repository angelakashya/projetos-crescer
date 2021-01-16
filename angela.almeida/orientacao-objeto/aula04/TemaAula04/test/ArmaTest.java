import Arena.Posicao;
import Armas.ArcoDoHawkeye;
import Armas.Dragonfang;
import Armas.ManoplaDoInfinito;
import Armas.Mijolnir;
import org.junit.Assert;
import org.junit.Test;

public class ArmaTest {
    @Test
    public void dadoArcoDoHawkeyeEADistanciaEuclidianaForMenorQue100DeveRetornarZero() {
        //arrange
        ArcoDoHawkeye arco = new ArcoDoHawkeye();
        Posicao posicao1 = new Posicao(0, 0);
        Posicao posicao2 = new Posicao(0, 0);
        int danoEsperado = 0;

        //act
        int danoFinal = arco.calcularDano(posicao1, posicao2);

        //assert
        Assert.assertEquals(danoEsperado, danoFinal);
    }

    @Test
    public void dadoArcodoHawkeyeEADistanciaEuclidianaForMaiorOuIgualA100DeveRealizarOCalculo() {
        //arrange
        ArcoDoHawkeye arco = new ArcoDoHawkeye();
        Posicao posicao1 = new Posicao(9500, 1500);
        Posicao posicao2 = new Posicao(8700, 2500);
        int danoEsperado = 120;

        //act
        int danoFinal = arco.calcularDano(posicao1, posicao2);

        //assert
        Assert.assertEquals(danoEsperado, danoFinal);
    }

    @Test
    public void dadoDragonfangEADistanciaEuclidianaForMenorQueCincoDeveRetornarZero() {
        //arrange
        Dragonfang dragonfang = new Dragonfang();
        Posicao posicao1 = new Posicao(0, 0);
        Posicao posicao2 = new Posicao(0, 0);
        int danoEsperado = 0;

        //act
        int danoFinal = dragonfang.calcularDano(posicao1, posicao2);

        //arrange
        Assert.assertEquals(danoEsperado, danoFinal);
    }

    @Test
    public void dadoDragonfangEADistanciaEuclidianaForMaiorQueCincoDeveRealizarOCalculo() {
        //arrange
        Dragonfang dragonfang = new Dragonfang();
        Posicao posicao1 = new Posicao(9500, 1500);
        Posicao posicao2 = new Posicao(8700, 2500);
        int danoEsperado = 300;

        //act
        int danoFinal = dragonfang.calcularDano(posicao1, posicao2);

        //arrange
        Assert.assertEquals(danoEsperado, danoFinal);
    }

    @Test
    public void dadoMijolnirDeveRetornarODanoDeOitenta() {
        //arrange
        Mijolnir mijolnir = new Mijolnir();
        int danoEsperado = 80;

        //act
        int danoFinal = mijolnir.getDanoArma();

        //assert
        Assert.assertEquals(danoEsperado, danoFinal);
    }

    @Test
    public void dadoManoplaDoInfinitoDeveRetornarODanoCorreto() {
        //arrange
        ManoplaDoInfinito manoplaDoInfinito = new ManoplaDoInfinito();
        int danoEsperado = 2147483647;

        //act
        int danoFinal = manoplaDoInfinito.getDanoArma();

        //assert
        Assert.assertEquals(danoEsperado, danoFinal);
    }

}
