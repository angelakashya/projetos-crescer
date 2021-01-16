import org.junit.Assert;
import org.junit.Test;

public class ExemploTesteUnitario {

    @Test
    public void soma() {
        //arrage
        int primeiroValor = 2;
        int segundoValor = 2;
        int valorEsperado = 4;
        //act
        int soma = primeiroValor + segundoValor;

        //assert
        Assert.assertEquals(valorEsperado, soma);
    }

    @Test
    public void subtracao() {
        //arrage
        int primeiroValor = 2;
        int segundoValor = 2;
        int valorEsperado = 0;

        //act
       int subtracao =  primeiroValor - segundoValor;

       //assert
        Assert.assertEquals(valorEsperado, subtracao);
    }

    @Test
    public void multiplicacao() {
        //arrage
        int primeiroValor = 2;
        int segundoValor = 2;
        int valorEsperado = 4;

        //act
        int multiplicacao = primeiroValor * segundoValor;

        //assert
        Assert.assertEquals(valorEsperado, multiplicacao);
    }

    @Test
    public void delta() {
        double pi = 3.14159;
        double valorComparacao = 3.14;
        Assert.assertEquals(valorComparacao, pi, 0.01);
    }
}
