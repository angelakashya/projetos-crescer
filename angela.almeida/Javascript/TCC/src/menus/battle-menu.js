import { upsertCharacter } from './character-menu'

export async function battle(personagem, inimigo, useLocalStorage) {
    console.log('ººº~ Vamos Batalhar ~ººº')


    return new Promise((resolve, reject) => {
        console.log('Executando batalha')

        setTimeout(() => {
            while (personagem.vidaBase > 0 || inimigo.vidaBase > 0) {
                inimigo.vidaBase -= personagem.danoBase
                console.log(`${personagem.nome} atacou ${inimigo.nome} e tirou ${personagem.danoBase} pontos de dano`)
                personagem.vidaBase -= inimigo.danoBase
                console.log(`${inimigo.nome} atacou ${personagem.nome} e tirou ${inimigo.danoBase} pontos de dano`)
                upsertCharacter(inimigo, useLocalStorage)
                upsertCharacter(personagem, useLocalStorage)
            }
            resolve('Batalha encerrada')
        }, 2000)
    })
}
export async function chooseEnemy(useLocalStorage, useQuestion) {
    let inimigoValido = false
    let indexInvalido = false
    const personagens = useLocalStorage.getObject('personagens')

    do {
        console.clear()
        if (indexInvalido)
            console.log('**Inimigo selecionado não existe, escolha um listado abaixo**')
        else
            console.log('=> Selecione seu inimigo <=')

        for (let i = 0; i < personagens.length; i++) {
            console.log(`${i + 1}. ${personagens[i].nome}`)
        }

        const personagemIndex = parseInt(await useQuestion('Digite o número do inimigo:') - 1)

        for (let i = 0; i < personagens.length; i++) {
            if (personagemIndex === i) {
                inimigoValido = true
                return personagens[i]
            }
        }

        indexInvalido = true

    } while (!inimigoValido)
}
