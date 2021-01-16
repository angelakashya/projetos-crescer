import pokemons from '../pokemons.json'

export function criarTreinador(nome, idade, pokemonInicial) {
    return {
        nome,
        idade,
        pokemons: [pokemonInicial]
    }
}

export function capturar(treinador, pokemonCapturado) {
    const NovoTreinador = atualizarPokemons(treinador)

    return {
         ...Novotreinador,
          pokemons: [...Novotreinador.pokemons, pokemonCapturado],
         }
}

export function atualizarPokemons(treinador) {
    const pokemonsAtualizados = treinador.pokemon.map((pokemon) => {
        if(pokemon.evolucao) {
            if(pokemon.evolucao.level <= pokemon.levelInicial + 1) {
                const pokemonEvoluido = evoluir(pokemon)
                return {...pokemonEvoluido}
            }
        }
        return {...treinador, pokemons: pokemonsAtualizados}
    })
}

export function evoluir(pokemons) {
    const idPokemon = pokemons.evolucao.id
    const pokemonEvoluido = pokemons.find(
        (pokemon) => pokemon.id === idPokemon
    )
    return {...pokemonEvoluido}
}




