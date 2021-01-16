import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import mapa.Mapa;
import org.junit.Assert;
import org.junit.Test;
import personagens.*;

public class GuerreiroTest {
    @Test
    public void guerreiroDeveAtacarOInimigoQuandoOInimigoEstiverEmUmaPosicaoDeDiferencaEDeveTirarPontosDeConstituicao() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        //arrange
        Mapa mapa = new Mapa();
        Gimli gimli = new Gimli();
        Orc orc = new Orc();
        mapa.inserir(0, gimli);
        mapa.inserir(1, orc);
        int constituicaoFinalEsperadaDoOrc = 12;

        //act
        gimli.atacar(mapa);
        int constituicaoFinalDoOrc = orc.getConstituicao();

        //assert
        Assert.assertEquals(constituicaoFinalEsperadaDoOrc, constituicaoFinalDoOrc);
    }

    @Test
    public void guerreiroNaoAtacaInimigoPoisInimigoNaoEstaProximo() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        //arrange
        Mapa mapa = new Mapa();
        Gimli gimli = new Gimli();
        Orc orc = new Orc();
        mapa.inserir(0, gimli);
        mapa.inserir(2, orc);
        int constituicaoFinalEsperadaDoOrc = 30;

        //act
        gimli.atacar(mapa);
        int constituicaoFinalDoOrc = orc.getConstituicao();

        //assert
        Assert.assertEquals(constituicaoFinalEsperadaDoOrc, constituicaoFinalDoOrc);
    }


    @Test
    public void personagemDeveCaminharNoMapa() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        //arrange
        Mapa mapa = new Mapa();
        Gimli gimli = new Gimli();
        mapa.inserir(0, gimli);
        int posicaoEsperadaDoGimli = 1;

        //act
        gimli.caminhar(mapa);
        int posicaoFinalDoGimli = mapa.buscarPosicao(gimli);

        //assert
        Assert.assertEquals(posicaoEsperadaDoGimli, posicaoFinalDoGimli);
    }

    @Test
    public void personagemNaoDeveConseguirCaminharNoMapaPorqueAProximaPosicaoEstaOcupada() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        //arrange
        Mapa mapa = new Mapa();
        Gimli gimli = new Gimli();
        Urukhai urukhai = new Urukhai();
        mapa.inserir(0, gimli);
        mapa.inserir(1, urukhai);
        int posicaoEsperadaDoGimli = 0;

        //act
        gimli.caminhar(mapa);
        int posicaoFinalDoGimli = mapa.buscarPosicao(gimli);

        //assert
        Assert.assertEquals(posicaoEsperadaDoGimli, posicaoEsperadaDoGimli);
    }
}
