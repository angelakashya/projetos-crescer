import classes.Mago;
import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import mapa.Mapa;
import org.junit.Assert;
import org.junit.Test;
import personagens.*;

public class MagoTest {
    @Test
    public void gandalfDeveAtacarInimigosETirarDezPontosDeConstituicao() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        //arrange
        Mapa mapa = new Mapa();
        Gandalf gandalf = new Gandalf();
        Saruman saruman = new Saruman();
        Orc orc = new Orc();
        mapa.inserir(0, gandalf);
        mapa.inserir(9, saruman);
        mapa.inserir(8, orc);
        int constituicaoFinalEsperadaDoSaruman = 60;
        int constituicaoFinalEsperadaDoOrc = 20;

        //act
        gandalf.atacar(mapa);
        int constituicaoFinalRetornadaDoSaruman = saruman.getConstituicao();
        int constituicaoFinalRetornadaDoOrc = orc.getConstituicao();

        //assert
        Assert.assertEquals(constituicaoFinalEsperadaDoSaruman, constituicaoFinalRetornadaDoSaruman);
        Assert.assertEquals(constituicaoFinalEsperadaDoOrc, constituicaoFinalRetornadaDoOrc);
    }

    @Test
    public void sarumanDeveAtacarInimigosETirarNovePontosDeConstituicao() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        //arrange
        Mapa mapa = new Mapa();
        Gandalf gandalf = new Gandalf();
        Saruman saruman = new Saruman();
        Legolas legolas = new Legolas();
        mapa.inserir(0, gandalf);
        mapa.inserir(9, saruman);
        mapa.inserir(1, legolas);
        int constituicaoFinalEsperadaDoGandalf = 71;
        int constituicaoFinalEsperadaDoLegolas = 71;

        //act
        saruman.atacar(mapa);
        int constituicaoFinalRetornadaDoGandalf = gandalf.getConstituicao();
        int constituicaoFinalRetornadaDoLegolas= legolas.getConstituicao();

        //assert
        Assert.assertEquals(constituicaoFinalEsperadaDoLegolas, constituicaoFinalRetornadaDoGandalf);
        Assert.assertEquals(constituicaoFinalEsperadaDoGandalf, constituicaoFinalRetornadaDoLegolas);
    }

    @Test
    public void magoDeveConseguirCaminharPoisOMapaEstaVazio() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        //arrange
        Mapa mapa = new Mapa();
        Gandalf gandalf = new Gandalf();
        mapa.inserir(0,gandalf);
        int posicaoEsperadaFinalDoGandalf = 1;

        //act
        gandalf.caminhar(mapa);
        int posicaoFinalDoGandalf = mapa.buscarPosicao(gandalf);

        //assert
        Assert.assertEquals(posicaoEsperadaFinalDoGandalf, posicaoFinalDoGandalf);
    }

    @Test
    public void magoNaoPoderaCaminharNoMapaPoisMapaNaoEstaVazio() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        //arrange
        Mapa mapa = new Mapa();
        Gandalf gandalf = new Gandalf();
        Legolas legolas = new Legolas();
        Goblim goblim = new Goblim();
        mapa.inserir(0,gandalf);
        mapa.inserir(2,legolas);
        mapa.inserir(8, goblim);
        int posicaoEsperadaFinalDoGandalf = 0;

        //act
        gandalf.caminhar(mapa);
        int posicaoFinalDoGandalf = mapa.buscarPosicao(gandalf);

        //assert
        Assert.assertEquals(posicaoEsperadaFinalDoGandalf, posicaoFinalDoGandalf);
    }
}
