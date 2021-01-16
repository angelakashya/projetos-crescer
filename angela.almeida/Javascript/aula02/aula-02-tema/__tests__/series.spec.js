import series from './series'
import {
  verificarSeAtorEstaEmSeriado,
  filtarPorAnoERetornarNome,
  calcularMediaTotalDeEpisodios,
  agruparTituloDasSeriesPorPropriedade,
} from '../src/metodos'

describe('Tema series - filtros com ano de estreia', () => {

  it('Deve filtrar as series com ano de estreia maior ou igual a 2010 e retornar uma listagem com os nomes', () => {
    const resultadoEsperado = [
      'Stranger Things',
      'Game Of Thrones',
      'The Walking Dead',
      'Band of Brothers',
      'Gus and Will The Masters of the Wizards',
      '10 Days Why',
      'Mr. Robot',
      'Narcos',
      'Westworld',
    ]

    const ANO = 2010

    const tituloDasSeriesComAnoDeEstreiaAcimaOuIgualA2010 = filtarPorAnoERetornarNome(series, ANO)

    expect(tituloDasSeriesComAnoDeEstreiaAcimaOuIgualA2010).toEqual(resultadoEsperado)
  })


  it('Deve filtrar as series com ano de estreia maior ou igual a 2015 e retornar uma listagem com os nomes', () => {
    const resultadoEsperado = [
      'Stranger Things',
      'Band of Brothers',
      'Gus and Will The Masters of the Wizards',
      'Mr. Robot',
      'Narcos',
      'Westworld',
    ]

    const ANO = 2015

    const tituloDasSeriesComAnoDeEstreiaAcimaOuIgualA2015 = filtarPorAnoERetornarNome(series, ANO)

    expect(tituloDasSeriesComAnoDeEstreiaAcimaOuIgualA2015).toEqual(resultadoEsperado)
  })
})


describe('Tema series - verificar se Ator esta em seriado ', () => {

  it('Deve retornar true ao procurar ator que está em elenco', () => {
    const NOME_ATOR = 'Peter Dinklage'

    const atorFoiEncontrado = verificarSeAtorEstaEmSeriado(series, NOME_ATOR)

    expect(atorFoiEncontrado).toBe(true)
  })


  it('Deve retornar false se ator não participa de elenco', () => {
    const NOME_ATOR = 'Silvio Santos'

    const atorNaoEncontrado = verificarSeAtorEstaEmSeriado(series, NOME_ATOR)

    expect(atorNaoEncontrado).toBe(false)
  })
})

describe('Tema series - verificar media total de episodios', () => {

  it('Deve calcular a media total de episódios de todas as series', () => {
    const MEDIA_TOTAL = 34.1

    expect(calcularMediaTotalDeEpisodios(series)).toBe(MEDIA_TOTAL)
  })
})

describe('Tema series - deve agrupar os seriados baseado em uma propriedade desajada', () => {

  it('Deve agrupar corretamente baseado na Distribuidora', () => {
    const PROPRIEDADE_DISTRIBUDORA = 'distribuidora'

    const tituloDasSeriesAgrupadasPelaDistribuidora = agruparTituloDasSeriesPorPropriedade(series, PROPRIEDADE_DISTRIBUDORA)

    expect(tituloDasSeriesAgrupadasPelaDistribuidora).toEqual(
      {
        "AMC": ["The Walking Dead", "Breaking Bad"],
        "CWI": ["Gus and Will The Masters of the Wizards"],
        "HBO": ["Game Of Thrones", "Band of Brothers", "Westworld"],
        "JS": ["10 Days Why"],
        "Netflix": ["Stranger Things", "Narcos"],
        "USA Network": ["Mr. Robot"]
      }
    )
  })

  it('Deve agrupar corretamente baseado no numero de Temporadas', () => {
    const PROPRIEDADE_TEMPORADAS = 'temporadas'

    const tituloDasSeriesAgrupadasPelaDistribuidora = agruparTituloDasSeriesPorPropriedade(series, PROPRIEDADE_TEMPORADAS)

    expect(tituloDasSeriesAgrupadasPelaDistribuidora).toEqual(
      {
        "1": ["Stranger Things", "Band of Brothers", "Gus and Will The Masters of the Wizards", "Westworld"],
        "10": ["10 Days Why"],
        "2": ["Mr. Robot", "Narcos"],
        "5": ["Breaking Bad"],
        "6": ["Game Of Thrones"],
        "7": ["The Walking Dead"]
      }
    )
  })

})

