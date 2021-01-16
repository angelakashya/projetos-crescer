package Recursos;

public abstract class Recurso {

    private final int valor;

    private final int peso;

    public Recurso(int valor, int peso) {
        this.valor = valor;
        this.peso = peso;
    }

    public int getValor() {
        return valor;
    }

    public int getPeso() {
        return peso;
    }
}

