import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import mapa.Mapa;
import org.junit.Assert;
import org.junit.Test;
import personagens.*;

public class MapaTest {


    @Test
    public void deveExibirTodasPosicoesDoMapaVazio() {
        //assert
        Mapa mapa = new Mapa();
        String exibicaoEsperada = "| | | | | | | | | | |";

        //act
        String exibicaoFinal = mapa.exibir();

        //assert
        Assert.assertEquals(exibicaoEsperada, exibicaoFinal);

    }

    @Test
    public void deveInserirUmPersonagemNaPosicaoIndicada() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        //assert
        Mapa mapa = new Mapa();
        Personagem[] personagems = new Personagem[10];
        Aragorn aragorn = new Aragorn();
        String insercaoEsperada = "|A| | | | | | | | | |";

        //act
        mapa.inserir(0, aragorn);
        String insercaoFinal = mapa.exibir();

        //Assert
        Assert.assertEquals(insercaoEsperada, insercaoFinal);
    }

    @Test(expected = PersonagemJaEstaNoMapaException.class)
    public void deveEstourarPersonagemJaEstaNoMapaExceptionQuandoEuTentarInserirUmPersonagemQueJáEstaNoMapa() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        //arrange
        Mapa mapa = new Mapa();
        Personagem[] personagems = new Personagem[10];
        Aragorn aragorn = new Aragorn();


        //act
        mapa.inserir(0, aragorn);
        mapa.inserir(1, aragorn);
    }

    @Test(expected = PosicaoOcupadaException.class)
    public void deveEstourarPosicaoOcupadaException() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        //arrange
        Mapa mapa = new Mapa();
        Personagem[] personagems = new Personagem[10];
        Aragorn aragorn = new Aragorn();
        Legolas legolas = new Legolas();


        //act
        mapa.inserir(0, legolas);
        mapa.inserir(0, aragorn);
    }

    @Test
    public void dadoPersonagemDeveRetornarAPosicaoEmQualEleSeEncontraNoMapa() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        //arrange
        Mapa mapa = new Mapa();
        Personagem[] personagems = new Personagem[10];
        Aragorn aragorn = new Aragorn();
        Legolas legolas = new Legolas();
        Gandalf gandalf = new Gandalf();
        int posicaoEsperada = 2;

        //act
        mapa.inserir(0, aragorn);
        mapa.inserir(1, legolas);
        mapa.inserir(2, gandalf);
        int posicaoEncontrada = mapa.buscarPosicao(gandalf);

        //Assert
        Assert.assertEquals(posicaoEsperada, posicaoEncontrada);
    }

    @Test (expected = PersonagemNaoEncontradoNoMapaException.class)
    public void deveEstourarPersonagemNaoEncontradoNoMapaExceptionQuandoOPersonagemNaoEstiverInserido() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        //arrange
        Mapa mapa = new Mapa();
        Personagem[] personagems = new Personagem[10];
        Aragorn aragorn = new Aragorn();
        Legolas legolas = new Legolas();
        Gandalf gandalf = new Gandalf();
        int posicaoEsperada = 2;

        //act
        mapa.inserir(0, aragorn);
        mapa.inserir(1, legolas);
        int posicaoEncontrada = mapa.buscarPosicao(gandalf);
    }

    @Test
    public void dadoPosicaoDeveRetornarNullPoisNaoContemPersonagemNela() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        //arrange
        Mapa mapa = new Mapa();
        Personagem[] personagems = new Personagem[10];
        Aragorn aragorn = new Aragorn();
        Legolas legolas = new Legolas();
        Gandalf gandalf = new Gandalf();
        Personagem personagemEsperado = null;

        //act
        mapa.inserir(0, aragorn);
        mapa.inserir(1, legolas);
        Personagem personagemEncontrado = mapa.buscarCasa(2);

        //assert
        Assert.assertEquals(personagemEsperado, personagemEncontrado);
    }

    @Test
    public void dadoPersonagemDaSociedadeDoAnelEleDeveCaminharDaEsquerdaParaDireitaNoMapa() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        //arrange
        Mapa mapa = new Mapa();
        Aragorn aragorn = new Aragorn();
        int posicaoFinalEsperada = 1;

        //act
        mapa.inserir(0, aragorn);
        aragorn.caminhar(mapa);
        int posicaoFinalDoPersonagem = mapa.buscarPosicao(aragorn);

        //assert
        Assert.assertEquals(posicaoFinalEsperada, posicaoFinalDoPersonagem);
    }

    @Test
    public void dadoPersonagemDaLegiaoDeSauronEleDeveCaminharDaDireitaParaEsquerdaNoMapa() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        //arrange
        Mapa mapa = new Mapa();
        Orc orc = new Orc();
        int posicaoFinalEsperada = 8;

        //act
        mapa.inserir(9, orc);
        orc.caminhar(mapa);
        int posicaoFinalDoPersonagem = mapa.buscarPosicao(orc);

        //assert
        Assert.assertEquals(posicaoFinalEsperada, posicaoFinalDoPersonagem);
    }
}
