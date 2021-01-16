import org.junit.Assert;
import org.junit.Test;
import Recursos.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlanetaTest {

    @Test
    public void deveTerValorTotalZeradoQuandoNaoExistirNenhumRecurso() {
        int valorTotalEsperado = 0;
        Planeta tatooine = new Planeta(1, new ArrayList<>());

        int valorTotalRetornado = tatooine.getValorTotal();

        Assert.assertEquals(valorTotalEsperado, valorTotalRetornado);
    }

    @Test
    public void deveTerValorTotalQuandoExistirRecursosNoPlaneta() {
        int valorTotalEsperado = 600;
        List<Recurso> recursos = Arrays.asList(new Agua(), new Oxigenio(), new Ouro());
        Planeta tatooine = new Planeta(1, recursos);

        int valorTotalRetornado = tatooine.getValorTotal();

        Assert.assertEquals(valorTotalEsperado, valorTotalRetornado);
    }

    @Test
    public void deveTerValorPorPesoZeradoQuandoNaoExistirNenhumRecurso() {
        int valorPorPesoEsperado = 0;
        Planeta tatooine = new Planeta(1, new ArrayList<>());

        int valorPorPesoRetornado = tatooine.getValorPorPeso();

        Assert.assertEquals(valorPorPesoEsperado, valorPorPesoRetornado);
    }

    @Test
    public void deveTerValorPorPesoQuandoExistirRecursosNoPlaneta() {
        int valorPorPesoEsperado = 172;
        List<Recurso> recursos = Arrays.asList(new Agua(), new Oxigenio(), new Ouro());
        Planeta tatooine = new Planeta(1, recursos);

        int valorPorPesoRetornado = tatooine.getValorPorPeso();

        Assert.assertEquals(valorPorPesoEsperado, valorPorPesoRetornado);
    }
}

