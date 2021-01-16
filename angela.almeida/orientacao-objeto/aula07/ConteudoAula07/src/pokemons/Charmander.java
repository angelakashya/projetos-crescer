package pokemons;

import exceptions.NaoPossuiEvolucaoException;
import exceptions.NivelMuitoBaixoParaEvolucaoException;

public class Charmander extends Pokemon{

    private static final Tipo TIPO = Tipo.FOGO;

    private static final int NIVEL_MIN_EVOLUCAO = 16;

    public Charmander(int nivel) {
        super(nivel, TIPO);
    }

    @Override
    public Charmeolon evoluir() throws NivelMuitoBaixoParaEvolucaoException {
        if(getNivel() < NIVEL_MIN_EVOLUCAO)
            throw new NivelMuitoBaixoParaEvolucaoException(getNivel(), NIVEL_MIN_EVOLUCAO);

        return new Charmeolon(getNivel());
    }
}
