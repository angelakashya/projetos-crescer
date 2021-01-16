package pokemons;
import exceptions.NaoPossuiEvolucaoException;
import exceptions.NivelMuitoBaixoParaEvolucaoException;

public abstract class Pokemon {

    private final Tipo tipo;

    private int nivel;

    public Pokemon(int nivel, Tipo tipo) {
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void aumentarNivel() {
        this.nivel++;
    }

    public Pokemon evoluir() throws NaoPossuiEvolucaoException, NivelMuitoBaixoParaEvolucaoException {
        throw new NaoPossuiEvolucaoException();
    }
}
