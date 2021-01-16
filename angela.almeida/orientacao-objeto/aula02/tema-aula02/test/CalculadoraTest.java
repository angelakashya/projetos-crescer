import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {
    @Test
    public void testSoma() {
        //arrange
        Calculadora calculadora = new Calculadora();
        double numero1 = 20.0;
        double numero2 = 30.0;
        double resultadoEsperado = 50.0;

        //act
        double resultado = calculadora.soma(numero1, numero2);

        //assert
        Assert.assertEquals(resultadoEsperado, resultado, 0.01);
    }

    @Test
    public void testSubtracao() {
        //arrange
        Calculadora calculadora = new Calculadora();
        double numero1 = 50.0;
        double numero2 = 30.0;
        double resultadoEsperado = 20.0;

        //act
        double resultado = calculadora.subtração(numero1, numero2);

        //assert
        Assert.assertEquals(resultadoEsperado, resultado, 0.01);
    }

    @Test
    public void testMultiplicacao() {
        //arrange
        Calculadora calculadora = new Calculadora();
        double numero1 = 20.0;
        double numero2 = 30.0;
        double resultadoEsperado = 600.0;

        //act
        double resultado = calculadora.multiplicacao(numero1, numero2);

        //assert
        Assert.assertEquals(resultadoEsperado, resultado, 0.01);
    }

    @Test
    public void testDivisao() {
        //arrange
        Calculadora calculadora = new Calculadora();
        double numero1 = 100.0;
        double numero2 = 20.0;
        double resultadoEsperado = 50.0;

        //act
        double resultado = calculadora.divisao(numero1, numero2);

        //assert
        Assert.assertEquals(resultadoEsperado, resultado, 0.01);
    }

    @Test
    public void testPotencia() {
        //arrange
        Calculadora calculadora = new Calculadora();
        double numero = 2.0;
        double expoente = 2.0;
        double resultadoEsperado = 4.0;

        //act
        double resultado = calculadora.potencia(numero, expoente);

        //assert
        Assert.assertEquals(resultadoEsperado, resultado, 0.01);
    }

    @Test
    public void testRaiz() {
        //arrange
        Calculadora calculadora = new Calculadora();
        double numero = 25.0;
        double resultadoEsperado = 5.0;

        //act
        double resultado = calculadora.raizQuadrada(numero);

        //assert
        Assert.assertEquals(resultadoEsperado, resultado, 0.01);

    }

}
