import org.junit.Assert;
import org.junit.Test;
import Carro.*;
import Circuito.*;
import Peças.*;
import Trajetos.*;
import java.util.*;

public class CircuitoTest {

    @Test
    public void deveRealizarCorridaComTodosOsCarrosCompletandoQuandoPistaForFacil() {
        int quantidadeEsperada = 3;
        List<Trajeto> pista = new ArrayList<>();
        List<Carro> grid = new ArrayList<>();
        Circuito interlagos = new Circuito(pista);
        Carro ferrari = new Carro();
        Carro mercedes = new Carro();
        Carro redBull = new Carro();

        pista.add(new Reta(2));
        pista.add(new Curva(2));
        pista.add(new Reta(2));
        grid.add(ferrari);
        grid.add(mercedes);
        grid.add(redBull);
        List<Carro> finalistas = interlagos.realizarCorrida(grid);

        Assert.assertEquals(quantidadeEsperada, finalistas.size());
    }

    @Test
    public void deveRealizarCorridaComNenhumCarroCompletandoQuandoPistaForDificil() {
        int quantidadeEsperada = 0;
        List<Trajeto> pista = new ArrayList<>();
        List<Carro> grid = new ArrayList<>();
        Circuito interlagos = new Circuito(pista);
        Carro ferrari = new Carro();
        Carro mercedes = new Carro();
        Carro redBull = new Carro();

        pista.add(new Reta(20));
        pista.add(new Curva(30));
        pista.add(new Reta(20));
        grid.add(ferrari);
        grid.add(mercedes);
        grid.add(redBull);
        List<Carro> finalistas = interlagos.realizarCorrida(grid);

        Assert.assertEquals(quantidadeEsperada, finalistas.size());
    }
}


