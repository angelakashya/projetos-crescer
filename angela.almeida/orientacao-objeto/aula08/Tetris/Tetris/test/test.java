import org.junit.Test;
import pecas.Peca;
import pecas.QuadradoP;
import pecas.RetanguloP;

public class test {

    @Test
    public void gerarTabuleiro(){

        Tetris tetris=new Tetris(5,15);
        tetris.reproduzirJogo();

        System.out.println(tetris.getPontos());
        tetris.mostrarTabuleiro();

    }
}
