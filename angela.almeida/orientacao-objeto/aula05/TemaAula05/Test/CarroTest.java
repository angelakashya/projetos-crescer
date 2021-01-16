import org.junit.Assert;
import org.junit.Test;
import Carro.*;
import Circuito.*;
import Peças.*;
import Trajetos.*;
import java.util.*;

public class CarroTest {
   @Test
    public void motorDoCarroDeveSerTunado() {
       Carro ka = new Carro();
       List<Trajeto> pista = new ArrayList<>();
       pista.add(new Reta(50));
       ka.correr(pista);
       int qualidadeEsperada = 100;

       Motor motor = new Motor(100);

       ka.tunar(motor);

       int qualidadeMotor = ka.getMotor().getQualidade();

       Assert.assertEquals(qualidadeEsperada, qualidadeMotor);

   }
    @Test
    public void freioDoCarroDeveSerTunado() {
        Carro ka = new Carro();
        List<Trajeto> pista = new ArrayList<>();
        pista.add(new Reta(50));
        ka.correr(pista);
        int qualidadeEsperada = 100;

        Freio freio = new Freio(100);

        ka.tunar(freio);

        int qualidadeFreio = ka.getFreio().getQualidade();

        Assert.assertEquals(qualidadeEsperada, qualidadeFreio);

    }
    @Test
    public void pneuDoCarroDeveSerTunado() {
        Carro ka = new Carro();
        List<Trajeto> pista = new ArrayList<>();
        pista.add(new Reta(50));
        ka.correr(pista);
        int qualidadeEsperada = 100;

        Pneu pneu = new Pneu(100);

        ka.tunar(pneu);

        int qualidadePneu = ka.getPneu().getQualidade();

        Assert.assertEquals(qualidadeEsperada, qualidadePneu);

    }


}
