import org.junit.Assert;
import org.junit.Test;
import Recursos.Agua;

public class RecursoTest {

    @Test
    public void deveTerValorCorretoQuandoAguaForCriada() {
        int valorEsperado = 180;
        Agua agua = new Agua();

        int valorRetornado = agua.getValor();

        Assert.assertEquals(valorEsperado, valorRetornado);
    }
}
