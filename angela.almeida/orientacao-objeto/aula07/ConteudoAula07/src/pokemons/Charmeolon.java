package pokemons;

import exceptions.NivelMuitoBaixoParaEvolucaoException;

public class Charmeolon extends Pokemon {
    private static final Tipo TIPO = Tipo.FOGO;

    private static final int NIVEL_MIN_EVOLUCAO = 26;

    public Charmeolon(int nivel) {
        super(nivel, TIPO);
    }

    @Override
    public Charmeolon evoluir() throws NivelMuitoBaixoParaEvolucaoException {
        if(getNivel() < NIVEL_MIN_EVOLUCAO)
            throw new NivelMuitoBaixoParaEvolucaoException(getNivel(), NIVEL_MIN_EVOLUCAO);

        return new Charmeolon(getNivel());
    }
}
