package Circuito;

import Carro.*;
import Trajetos.*;

import java.util.*;

public class Circuito {

    private List<Trajeto> pista;

    public Circuito(List<Trajeto> pista) {
        this.pista = pista;
    }

    public List<Carro> realizarCorrida(List<Carro> carros) {
        List<Carro> carrosCorrendo = new ArrayList<Carro>();
        for (Carro carro : carros) {
            if (carro.correr(pista) == false) {
                carrosCorrendo.add(carro);
            }
        }
        carros.removeAll(carrosCorrendo);
        return carros;
    }
}
