import pokemons from '../../pokemons.json'
import { capturar, criarTreinador, upar} from '../../src/index.js'

describe('Suite Pokemon', () => {
  
  it('Deve criar um treinador com o nome esperado', () => { 

    const nomeEsperado = 'Angela'
      const idade = 23;
      const pokemonInicial = pokemons[0];

      const treinador = criarTreinador(nomeEsperado, idade, pokemonInicial);

      expect(nomeEsperado).toEqual(treinador.nome);
  })


  it('DeveEvoluirOPrimeiroPokemon', () => {
    const nome = 'Angela'
    const idade = 23
    const pokemon = pokemons[0]
    const levelPokemon = pokemons[0].nivel
    const treinador = criarTreinador(nome, idade, pokemon)
    const novoTreinador = capturar(treinador, pokemons[5])
    const novoTreinador2 = capturar(
      novoTreinador,
      pokemons[5]
    )
    expect(levelPokemon).toEqual(novoTreinador2.pokemon[0].nivel)
  })

})