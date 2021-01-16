import org.junit.Assert;
import org.junit.Test;

public class CalculadoraComissaoTest {
    @Test
    public void testeCalculadoraComissao() {
        //arrange
        CalculadoraComissao calculadora = new CalculadoraComissao();
        double valorVendido = 1000;
        double porcentagemSobreValorVendido = 20;
        double comissaoEsperada = 200;

        //act
       double valorCalculado =  calculadora.calcularComissao(valorVendido, porcentagemSobreValorVendido);

        //assert
        Assert.assertEquals(comissaoEsperada, valorCalculado, 0.01);
    }
}
