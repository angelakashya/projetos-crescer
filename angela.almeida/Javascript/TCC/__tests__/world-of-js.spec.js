import { createCharacterMenu, chooseName, selectRace } from '../src/menus/character-menu'
import { selectMission } from '../src/menus/mission-menu';
import { buyItem } from '../src/menus/store-menu';
import { useLocalStorage } from '../src/services/local-storage/use-local-storage';

describe('World of Javascript', () => {
    it('chooseName deve retonar nome quando não existe nenhum outro personagem com o mesmo nome', async () => {
        // Arrange
        const useQuestionMock = () => new Promise(
            resolve => resolve('Eleonor')
        )

        const useLocalStorageTest = useLocalStorage('./db-test');
        useLocalStorageTest.setObject('personagens', [])
        const nomeEsperado = 'Eleonor'

        // Act
        const nome = await chooseName(useQuestionMock, useLocalStorageTest)

        // Assert
        expect(nome).toEqual(nomeEsperado)
    })

    it('selectRace deve retonar raça quando for uma raça válida', async () => {
        // Arrange
        const useQuestionMock = () => new Promise(
            resolve => resolve('8')
        )

        const racasMock = [{
            "id": 8,
            "nome": "Meio Elfo",
            "vidaBase": 5,
            "vigorBase": 4,
            "danoBase": 6
        }]

        const idRacaEsperado = 8

        // Act
        const raca = await selectRace(useQuestionMock, racasMock)

        // Assert
        expect(raca.id).toEqual(idRacaEsperado)
    })

    it('buyItem deve retornar o item comprado', async () => {
        // Arrange
        const useQuestionMock = () => new Promise(
            resolve => resolve('1')
        )

        const itensMock = [{
            "id": 1,
            "nome": "Espada curta",
            "tipo": "DANO",
            "preco": 40,
            "aprimoramento": 3
        }]

        const idItemEsperado = 1;

        // Act
        const item = await buyItem(useQuestionMock, 50, itensMock)

        // Assert 
        expect(item.id).toEqual(idItemEsperado)
    })

    it('selectMission deve selecionar a missao escolhida', async () => {
        // Arrange
        const useQuestionMock = () => new Promise(
            resolve => resolve('1')
        )

        const missionsMock = [{
            "id": 1,
            "descricao": "Limpar os canecos da taberna",
            "tempoEstimado": 5000,
            "niveisRecebidos": 0,
            "dinheiroRecebido": 10
        }]

        const idMissao= 1;

        // Act
        const missao = await selectMission(missionsMock, useQuestionMock)

        // Assert 
        expect(idMissao).toEqual(missao.id)
    })

    it('personagens devem batalhar', async () => {
        // Arrange
        const useQuestionMock = () => new Promise(
            resolve => resolve('1')
        )

        const missionsMock = [{
            "id": 1,
            "descricao": "Limpar os canecos da taberna",
            "tempoEstimado": 5000,
            "niveisRecebidos": 0,
            "dinheiroRecebido": 10
        }]

        const idMissao= 1;

        // Act
        const missao = await selectMission(missionsMock, useQuestionMock)

        // Assert 
        expect(idMissao).toEqual(missao.id)
    })
})