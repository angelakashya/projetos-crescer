package Carro;

import Peças.*;
import Trajetos.*;

import java.util.*;

public class Carro {

    private Motor motor;
    private Freio freio;
    private Pneu pneu;
    private static final int QUALIDADE_INICIAL = 100;

    public Carro() {
        this.motor = new Motor(QUALIDADE_INICIAL);
        this.freio = new Freio(QUALIDADE_INICIAL);
        this.pneu = new Pneu(QUALIDADE_INICIAL);
    }

    public boolean correr(List<Trajeto> trajeto) {
        for (int i = 0; i < trajeto.size(); i++) {
            if (motor.usarNoTrajeto(trajeto.get(i)) == 0 || freio.usarNoTrajeto(trajeto.get(i)) == 0 || pneu.usarNoTrajeto(trajeto.get(i)) == 0) {
                return false;
            }
        }
        return true;
    }

    public void tunar(Motor motor) {
        if(this.motor.getQualidade() < motor.getQualidade())
            this.motor = motor;
    }

    public void tunar(Pneu pneu) {
        if(this.pneu.getQualidade() < pneu.getQualidade())
            this.pneu = pneu;
    }

    public void tunar(Freio freio) {
        if(this.freio.getQualidade() < freio.getQualidade())
            this.freio = freio;
    }

    public Motor getMotor() {
        return motor;
    }

    public Freio getFreio() {
        return freio;
    }

    public Pneu getPneu() {
        return pneu;
    }
}
