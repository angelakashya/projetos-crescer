import pecas.*;

import java.util.Random;

public class Tetris {

    private static final int PONTOS_INICIAIS = 0;

    private int largura;
    private int altura;
    private Peca[] pecas;
    private int[][] tabuleiro;
    private int pontos;
    private boolean overflow;

    public Tetris(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        this.tabuleiro = new int[altura][largura];
        this.pontos = PONTOS_INICIAIS;
        this.overflow = false;
        this.inicializarPecas();
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public Peca[] getPecas() {
        return pecas;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }


    public void inicializarPecas() {
        Peca pecas[] = new Peca[]{new QuadradoP(), new QuadradoG(), new RetanguloP(), new RetanguloG()};
        this.pecas = pecas;
    }

    public Peca gerarPeca() {
        Random rand = new Random(); //instance of random class
        int upperbound = 4;
        int intAleatorio = rand.nextInt(upperbound);
        return this.pecas[intAleatorio];
    }

    public boolean verificarSePodeCortarLinha() {
        boolean linhaCompleta = true;
        for (int x = 0; x < this.largura; x++) {
            if (tabuleiro[altura - 1][x] == 0) {
                linhaCompleta = false;
                break;
            }
        }
        if (linhaCompleta) {
            incrementarPonto();
            cortarLinha();
            return true;
        }
        return false;

    }

    public void cortarLinha() {
        for (int x = altura-1; x > 0; x--) {
            tabuleiro[x] = tabuleiro[x - 1];
        }
        for (int x = 0; x < largura; x++) {
            tabuleiro[0][x] = 0;
        }
    }

    public void incrementarPonto() {
        this.pontos += 1;
    }

    public void reproduzirJogo() {
        Peca peca;
        while (!overflow){
            peca = gerarPeca();

            for (int i = altura - 1; i >= 0; i--) {//PERCORRE AS LINHAS DO TABULEIRO
                boolean pecaEncaixada = false;
                for (int j = 0; j <= this.largura - peca.getLargura(); j++) {//PERCORRE AS COLUNAS DO TABULEIRO
                    boolean podeEncaixar = true;


                    for (int k = j; k < j + peca.getLargura(); k++) {//verifa se tem largura disponivel para peca
                        if (tabuleiro[i][k] == 1) {
                            podeEncaixar = false;
                            break;
                        }
                    }

                    if (podeEncaixar) {
                        pecaEncaixada = encaixarPeca(i, j, peca);
                        break;
                    }
                }

                if (pecaEncaixada) {
                    break;
                } else {
                    overflow = true;
                    break;
                }

            }
        }

    }

    private boolean encaixarPeca(int altura, int largura, Peca peca) {
        if ((altura - (peca.getAltura() - 1)) < 0)
            return false;
        for (int i = altura; i > altura - peca.getAltura(); i--) {
            for (int j = largura; j < largura + peca.getLargura(); j++) {
                tabuleiro[i][j] = 1;
            }
        }

            while (verificarSePodeCortarLinha()){
                continue;
            }



        return true;
    }


    public void mostrarTabuleiro() {
        for (int x = 0; x < this.altura; x++) {
            for (int i = 0; i < this.largura; i++) {
                System.out.print(tabuleiro[x][i]);
            }
            System.out.println();
        }


    }

}
