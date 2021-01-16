import org.junit.Assert;
import org.junit.Test;
import Recursos.Agua;
import Recursos.Ouro;
import Recursos.Oxigenio;
import Recursos.Recurso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NaveTest {

    @Test
    public void deveZerarOCumbustivelQuandoCombustivelAcabar() {
        int combustivelEsperado = 0;
        Nave milleniumFalcon = new Nave(9);
        Planeta tatooine = new Planeta(4, new ArrayList<>());

        milleniumFalcon.explorar(tatooine);
        int combustivelResultante = milleniumFalcon.getQuantidadeDeCombustivel();

        Assert.assertEquals(combustivelEsperado, combustivelResultante);
    }

    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlaneta() {
        int posicaoEsperada = 3;
        Nave milleniumFalcon = new Nave(9);
        Planeta tatooine = new Planeta(4, new ArrayList<>());

        milleniumFalcon.explorar(tatooine);
        int posicaoResultante = milleniumFalcon.getPosicao();

        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void deveColetarRecursosDoPlanetaQuandoConseguirChegarAteEle() {
        List<Recurso> recursosEsperados = Arrays.asList(new Agua(), new Oxigenio(), new Ouro());
        Nave milleniumFalcon = new Nave(12);
        Planeta tatooine = new Planeta(4, recursosEsperados);

        milleniumFalcon.explorar(tatooine);
        List<Recurso> recursosRetornados = milleniumFalcon.getRecursosColetados();

        Assert.assertArrayEquals(recursosEsperados.toArray(), recursosRetornados.toArray());
    }

    @Test
    public void deveExplorarPlanetasBaseadoNoValorTotalQuandoComparadorForValorTotal() {
        List<Recurso> recursosEsperados = Arrays.asList(new Agua(), new Oxigenio(), new Ouro());
        Comparator comparator = Comparator.comparing(Planeta::getValorTotal).reversed();

        Nave milleniumFalcon = new Nave(120);

        List<Planeta> planetas = Arrays.asList(
                new Planeta(4, recursosEsperados),
                new Planeta(40, new ArrayList<>())
        );

        milleniumFalcon.explorar(planetas, comparator);
        List<Recurso> recursosRetornados = milleniumFalcon.getRecursosColetados();

        Assert.assertArrayEquals(recursosEsperados.toArray(), recursosRetornados.toArray());
    }
}

