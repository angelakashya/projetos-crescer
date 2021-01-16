import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import mapa.Mapa;
import org.junit.Assert;
import org.junit.Test;
import personagens.*;

import javax.xml.stream.FactoryConfigurationError;

public class ArqueiroTest {
    @Test
    public void legolasDeveAtacarInimigoLocalizadoNaPosicaoTres() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        //arrange
        Mapa mapa = new Mapa();
        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Urukhai urukhai = new Urukhai();
        mapa.inserir(0, legolas);
        mapa.inserir(2, orc);
        mapa.inserir(3, urukhai);
        int constituicaoFinalEsperadaDoOrc = 30;
        int constituicaoFinalEsperadaDoUrukhai = 15;

        //act
        legolas.atacar(mapa);
        int constituicaoFinalDoOrc = orc.getConstituicao();
        int constituicaoFinalDoUrukhai = urukhai.getConstituicao();

        //assert
        Assert.assertEquals(constituicaoFinalEsperadaDoOrc, constituicaoFinalDoOrc);
        Assert.assertEquals(constituicaoFinalEsperadaDoUrukhai, constituicaoFinalDoUrukhai);
    }

    @Test
    public void goblimDeveAtacarInimigoLocalizadoNaPosicaoTres() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        //arrange
        Mapa mapa = new Mapa();
        Goblim goblim = new Goblim();
        Legolas legolas = new Legolas();
        Aragorn aragorn = new Aragorn();
        mapa.inserir(9, goblim);
        mapa.inserir(7, legolas);
        mapa.inserir(6, aragorn);
        int constituicaoFinalEsperadaDoLegolas = 80;
        int constituicaoFinalEsperadaDoAragorn = 42;

        //act
        goblim.atacar(mapa);
        int constituicaoFinalDoLegolas = legolas.getConstituicao();
        int constituicaoFinalDoAragorn = aragorn.getConstituicao();

        //assert
        Assert.assertEquals(constituicaoFinalEsperadaDoAragorn, constituicaoFinalDoAragorn);
        Assert.assertEquals(constituicaoFinalEsperadaDoLegolas, constituicaoFinalDoLegolas);
    }

    @Test
    public void legolasNaoPodeAtacarGandalfPoisSaoDoMesmoTipo() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        //arrange
        Mapa mapa = new Mapa();
        Legolas legolas = new Legolas();
        Gandalf gandalf = new Gandalf();
        mapa.inserir(0, legolas);
        mapa.inserir(1, gandalf);
        int constituicaoFinalEsperadaDoGandalf = 80;

        //act
        legolas.atacar(mapa);
        int constituicaoFinalDoGandalf = gandalf.getConstituicao();

        //arrange
        Assert.assertEquals(constituicaoFinalEsperadaDoGandalf, constituicaoFinalDoGandalf);
    }

    @Test
    public void goblimNaoPodeAtacarOrcPoisSaoDoMesmoTipo() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        //arrange
        Mapa mapa = new Mapa();
        Goblim goblim = new Goblim();
        Orc orc = new Orc();
        mapa.inserir(9, goblim);
        mapa.inserir(8, orc);
        int constituicaoFinalEsperadaDoOrc = 30;

        //act
        goblim.atacar(mapa);
        int constituicaoFinalDoOrc = orc.getConstituicao();

        //assert
        Assert.assertEquals(constituicaoFinalEsperadaDoOrc, constituicaoFinalDoOrc);
    }

    @Test
    public void arqueiroDeveCaminharDuasPosicoesPoisEstaoLivres() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        //arrange
        Legolas legolas = new Legolas();
        Mapa mapa = new Mapa();
        mapa.inserir(0, legolas);
        int posicaoFinalEsperadaDoLegolas = 2;

        //act
        legolas.caminhar(mapa);
        int posicaoFinalDoLegolas = mapa.buscarPosicao(legolas);

        //assert
        Assert.assertEquals(posicaoFinalEsperadaDoLegolas, posicaoFinalDoLegolas);
    }
}
