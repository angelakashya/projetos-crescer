import Arena.Posicao;
import Armas.Dragonfang;
import Armas.Mijolnir;
import HabilidadesEspeciais.SemTalento;
import Vingador.Vingador;
import Arena.Arena;
import org.junit.Assert;
import org.junit.Test;

public class ArenaTest {
    @Test
    public void DeveDarEmpatePoisAmbosEstaoEmPosicoesMaioresQueLarguraDaArena() {
        //arrange
        Arena arena = new Arena(100, 100);
        Dragonfang arma = new Dragonfang();
        SemTalento habilidade = new SemTalento();
        Posicao posicao = new Posicao(200, 200);
        Vingador primeiro = new Vingador("Miranha", 100, arma, habilidade, posicao);
        Vingador segundo = new Vingador("Iron Man", 100, arma, habilidade, posicao);
        String ResultadoEsperado = "EMPATE";

        //act
       String VingadorVencedor =  arena.batalhar(primeiro, segundo);

       //assert
        Assert.assertEquals(ResultadoEsperado, VingadorVencedor);
    }

    @Test
    public void OPrimeiroDeveGanharPorDesistenciaDoSegundo() {
        //arrange
        Arena arena = new Arena(100, 100);
        Dragonfang arma = new Dragonfang();
        SemTalento habilidade = new SemTalento();
        Posicao posicao = new Posicao(2, 5);
        Posicao posicao2 = new Posicao(200, 200);
        Vingador primeiro = new Vingador("Miranha", 100, arma, habilidade, posicao);
        Vingador segundo = new Vingador("Iron Man", 100, arma, habilidade, posicao2);
        String ResultadoEsperado = primeiro.getNome();

        //act
        String VingadorVencedor = arena.batalhar(primeiro, segundo);

        //assert
        Assert.assertEquals(ResultadoEsperado, VingadorVencedor);
    }

    @Test
    public void OSegundoDeveGanharPorDesistenciaDoPrimeiro() {
        //arrange
        Arena arena = new Arena(100, 100);
        Dragonfang arma = new Dragonfang();
        SemTalento habilidade = new SemTalento();
        Posicao posicao = new Posicao(2, 5);
        Posicao posicao2 = new Posicao(200, 200);
        Vingador primeiro = new Vingador("Miranha", 100, arma, habilidade, posicao2);
        Vingador segundo = new Vingador("Iron Man", 100, arma, habilidade, posicao);
        String ResultadoEsperado = segundo.getNome();

        //act
        String VingadorVencedor = arena.batalhar(primeiro, segundo);

        //assert
        Assert.assertEquals(ResultadoEsperado, VingadorVencedor);
    }

    @Test
    public void OPrimeiroDeveGanharPorDarMaisDanoNoSegundo() {
        //arrange
        Arena arena = new Arena(100, 100);
        Dragonfang dragonfang = new Dragonfang();
        Mijolnir mijolnir = new Mijolnir();
        SemTalento habilidade = new SemTalento();
        Posicao posicao = new Posicao(2, 5);
        Posicao posicao2 = new Posicao(2, 5);
        Vingador primeiro = new Vingador("Miranha", 100, mijolnir , habilidade, posicao);
        Vingador segundo = new Vingador("Iron Man", 100, dragonfang, habilidade, posicao2);
        String ResultadoEsperado = primeiro.getNome();

        //act
        String VingadorVencedor = arena.batalhar(primeiro, segundo);

        //assert
        Assert.assertEquals(ResultadoEsperado, VingadorVencedor);
    }

    @Test
    public void OSegundoDeveGanharPorDarMaisDanoNoPrimeiro() {
        //arrange
        Arena arena = new Arena(100, 100);
        Dragonfang dragonfang = new Dragonfang();
        Mijolnir mijolnir = new Mijolnir();
        SemTalento habilidade = new SemTalento();
        Posicao posicao = new Posicao(2, 5);
        Posicao posicao2 = new Posicao(2, 5);
        Vingador primeiro = new Vingador("Miranha", 100, dragonfang, habilidade, posicao);
        Vingador segundo = new Vingador("Iron Man", 100, mijolnir, habilidade, posicao2);
        String ResultadoEsperado = segundo.getNome();

        //act
        String VingadorVencedor = arena.batalhar(primeiro, segundo);

        //assert
        Assert.assertEquals(ResultadoEsperado, VingadorVencedor);
    }



}
