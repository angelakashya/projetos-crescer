import exceptions.NivelMuitoBaixoParaEvolucaoException;
import org.junit.Test;
import pokemons.Charmander;

public class PokemonTest {
    @Test(expected =  NivelMuitoBaixoParaEvolucaoException.class)
    public void deveLancarNivelMuitoBaixoParaEvoluirExceptionQuandoPokemonNaoTiverNivelMinimo() throws NivelMuitoBaixoParaEvolucaoException {
        Charmander charmander = new Charmander(10);

        charmander.evoluir();
    }
}
