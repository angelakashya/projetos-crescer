import { SuperArray } from '../src/super-array'
import instrutores from './instrutores'

let INSTRUTORES

beforeEach(() => {
  INSTRUTORES = SuperArray(...instrutores)
})

describe('Tema - SuperArray', () => {
  it('push deve adicionar um novo instrutor ao meu array', () => {
    INSTRUTORES.push({ nome: 'Silvio Santos' })

    expect(INSTRUTORES.itens.length).toBe(9)
  })

  it('forEach deve passar por todos os instrutores e chamar o callback passando os parâmetros corretos', () => {
    const nomesInstrutores = SuperArray()

    INSTRUTORES.forEach(instrutor => {
      nomesInstrutores.push(instrutor.nome)
    })

    expect(nomesInstrutores.itens).toEqual([
      "Fabio Junqueira",
      "Pablo Oliveira",
      "Sergio Andrade",
      "Gustavo Büttenbender Rodrigues",
      "William Cardozo",
      "Sergio Andrade",
      "Rafael Zorzanelo",
      "Victor Herzog Damke"
    ])
  })


  it('filter deve retornar um novo array apenas com os instrutores que estão dando aula', () => {
    const instrutoresDandoAula = INSTRUTORES.filter(instrutor => instrutor.dandoAula)

    expect(instrutoresDandoAula.itens.length).toBe(2)
  })

  it('map deve retornar um novo array com o numero de nomes que o instrutor tem', () => {
    const numeroNomes = INSTRUTORES.map(instrutor => instrutor.nome.split(' ').length)

    expect(numeroNomes.itens).toEqual([2, 2, 2, 3, 2, 2, 2, 3])
  })

  it('find deve retornar o primeiro instrutor que está dando aula', () => {
    const primeiroInstrutorDandoAula = INSTRUTORES.find(instrutor => instrutor.dandoAula)

    expect(primeiroInstrutorDandoAula.nome).toBe('Gustavo Büttenbender Rodrigues')
  })

  it('find não deve econtrar instrutor que não esteja no projeto Crescer', () => {
    const instrutorNaoEncontrado = INSTRUTORES.find(instrutor => instrutor.nome === 'Silvio Santos')

    expect(instrutorNaoEncontrado).toBe(undefined)
  })

  it('reduce deve retornar o total de letras no nome dos instrutores', () => {
    const totalLetrasNomes = INSTRUTORES.reduce((ac, instrutor) => {
      return ac += instrutor.nome.replace(/ /g, '').length
    }, 0)

    expect(totalLetrasNomes).toEqual(127)
  })

  it('reduce deve retornar um objeto com a chave sendo o nome do instrutor, e o valor sendo se ele está dando aula', () => {
    const objetoInstrutores = INSTRUTORES.reduce((ac, instrutor) => {
      ac[instrutor.nome] = instrutor.dandoAula

      return ac
    }, {})

    expect(objetoInstrutores).toEqual({
      "Gustavo Büttenbender Rodrigues": true,
      "William Cardozo": true,
      "Fabio Junqueira": false,
      "Pablo Oliveira": false,
      "Sergio Andrade": false,
      "Sergio Andrade": false,
      "Rafael Zorzanelo": false,
      "Victor Herzog Damke": false
    })
  })

  it('reduce deve retornar um boolean se todos os instrutores estão dando aula', () => {
    const todosDandoAula = INSTRUTORES.reduce((ac, instrutor) => {
      return ac && instrutor.dandoAula
    }, true)
    
    expect(todosDandoAula).toBe(false)
  })
})
