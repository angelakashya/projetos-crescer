package zords;

public abstract class Zord {
    private int comprimento;
    private int altura;
    private int peso;
    private int velocidade;

    public Zord(int comprimento, int altura, int peso, int velocidade) {
        this.comprimento = comprimento;
        this.altura = altura;
        this.peso = peso;
        this.velocidade = velocidade;
    }

    public int getComprimento() {
        return comprimento;
    }

    public int getAltura() {
        return altura;
    }

    public int getPeso() {
        return peso;
    }

    public int getVelocidade() {
        return velocidade;
    }
}
