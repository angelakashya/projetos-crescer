import { useQuestion } from '../services/question/use-question'
import { upsertCharacter } from './character-menu'

export async function selectMission(missoes, useQuestion) {
    let missaoValida = false;
    let opcaoInvalida = false;


    do {
        console.clear()
        console.log("=> Bem vindo as nossas missões <=")

        if (opcaoInvalida)
            console.log('**Opção Inválida, selecione uma missão listada abaixo**')
        else
            console.log('Escolha qual missão deseja realizar')

        for (let i = 0; i < missoes.length; i++) {
            console.log(`${missoes[i].id}. ${missoes[i].descricao}`)
        }

        const idMissao = parseInt(await useQuestion('Digite o número da missão:'))

        for (let i = 0; i < missoes.length; i++) {
            if(idMissao === missoes[i].id) {
                missaoValida = true
                return missoes[i]
            }
        }
        opcaoInvalida = true

    } while (!missaoValida)
}

export async function executeMission(missao, personagem, useLocalStorage) { 
    console.clear()
    return new Promise((resolve, reject) => {
        console.log('Executando missão: ' + missao.descricao)

        setTimeout(() => {
            personagem.nivel += missao.niveisRecebidos
            personagem.dinheiro += missao.dinheiroRecebido
            upsertCharacter(personagem, useLocalStorage)
            resolve('Missão concluida')
        }, missao.tempoEstimado)
    })    
}