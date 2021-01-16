import { useLocalStorage } from '../services/local-storage/use-local-storage'
import { useQuestion } from '../services/question/use-question'
import { createCharacterMenu, selectCharacterMenu } from './character-menu'
import { gameMenu } from './game-menu'
import axios from 'axios'


export async function mainMenu() {
    let option = ''
    
    do {
        console.clear()
        console.log('~~~~~~~~# Bem Vindo ao World of Javascript #~~~~~~~~\n')
        console.log('1. Criar Personagem')
        console.log('2. Jogar com Personagem')
        console.log('3. Sair\n')
        option = await useQuestion('Selecione a opção:')

        switch (option) {
            case '1':
                const racas = await (await axios.get('https://tcc-js.herokuapp.com/races')).data
                await createCharacterMenu(useQuestion, useLocalStorage('./db'), racas)
                break;

            case '2':
                    const personagem = await selectCharacterMenu(useLocalStorage('./db'), useQuestion)
                    await gameMenu(personagem)
                break;

            case '3':
                console.log('Obrigada por jogar!')
                break;

            default:
                console.log('Opção Inválida!')
        }
    } while (option != '3')
}