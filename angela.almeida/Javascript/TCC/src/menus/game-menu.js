import { useQuestion } from '../services/question/use-question'
import { upsertCharacter } from './character-menu'
import { useLocalStorage } from '../services/local-storage/use-local-storage'
import { executeMission, selectMission } from './mission-menu'
import { buyItem } from './store-menu'
import { battle, chooseEnemy } from './battle-menu'
import axios from 'axios'

export async function gameMenu(personagem) {
    let option = ''
    const localStorage = useLocalStorage('./db')

    do {
        console.clear()
        console.log('~~~~~~~~# Escolha seu destino #~~~~~~~~\n')
        console.log('1. Batalhar com Personagens')
        console.log('2. Fazer uma Missão')
        console.log('3. Comprar um Item')
        console.log('4. Voltar ao menu principal\n')
        option = await useQuestion('Selecione a opção:')

        switch (option) {
            case '1':
                const inimigo = await chooseEnemy(localStorage, useQuestion)
                await battle(personagem, inimigo, localStorage, useQuestion)

                break;
            case '2':
                const missoes = await (await axios.get('https://tcc-js.herokuapp.com/quests')).data
                const missao = await selectMission(missoes, useQuestion)
                await executeMission(missao, personagem, localStorage)
                break;

            case '3':
                let itens = await (await axios.get('https://tcc-js.herokuapp.com/itens')).data
                const item = await buyItem(useQuestion, personagem.dinheiro, itens)
                if (item !== null) {
                    personagem.itens.push(item)
                    personagem.dinheiro -= item.preco
                }

                upsertCharacter(personagem, localStorage)

                break;

            default:
                console.log('Opção Inválida!')
        }
    } while (option != '4')

}