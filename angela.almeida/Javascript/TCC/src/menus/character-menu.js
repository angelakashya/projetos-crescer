export async function createCharacterMenu(useQuestion, useLocalStorage, racas) {
    console.log('Vamos criar seu personagem')

    const nome = await chooseName(useQuestion, useLocalStorage)
    const raca = await selectRace(useQuestion, racas)


    const personagem = {
        nome,
        raca,
        itens: [],
        nivel: 1,
        dinheiro: 0,
    }

    await upsertCharacter(personagem, useLocalStorage)
}

export function upsertCharacter(personagem, useLocalStorage) {
    let personagens = useLocalStorage.getObject('personagens') ?? []
    let personagemIndex = personagens.findIndex(p => p.nome === personagem.nome)

    if (personagemIndex === -1)
        personagens.push(personagem)
    else
        personagens[personagemIndex] = personagem

    useLocalStorage.setObject('personagens', personagens)
}

export async function selectCharacterMenu(useLocalStorage, useQuestion) {
    let personagemValido = false
    let indexInvalido = false
    const personagens = useLocalStorage.getObject('personagens')

    do {
        console.clear()
        if (indexInvalido)
            console.log('**Personagem selecionado não existe, escolha um listado abaixo**')
        else
            console.log('=> Selecione com qual personagem irá jogar! <=')

        for (let i = 0; i < personagens.length; i++) {
            console.log(`${i + 1}. ${personagens[i].nome}`)
        }

        const personagemIndex = parseInt(await useQuestion('Digite o número do personagem:') - 1)

        for (let i = 0; i < personagens.length; i++) {
            if (personagemIndex === i) {
                personagemValido = true
                return personagens[i]
            }
        }

        indexInvalido = true

    } while (!personagemValido)
}

export async function selectRace(useQuestion, racas) {
    let racaValida
    let opcaoInvalida = false

    do {
        console.clear()
        if (opcaoInvalida)
            console.log('Opção Inválida, selecione uma raça listado abaixo')
        else
            console.log('Selecione a sua raça')

        for (let i = 0; i < racas.length; i++) {
            console.log(`${racas[i].id}. ${racas[i].nome}`)
        }

        const idRaca = parseInt(await useQuestion('Digite o número da raça desejada'))
        for (let i = 0; i < racas.length; i++) {
            if (idRaca === racas[i].id) {
                racaValida = true
                return racas[i]
            }
        }

        opcaoInvalida = true
    } while (!racaValida)
}

export async function chooseName(useQuestion, useLocalStorage) {
    let personagens = useLocalStorage.getObject('personagens') ?? []
    let nomeInvalido
    let nome

    do {
        console.clear()

        if (nomeInvalido) {
            nome = await useQuestion('Nome já existente, escolha outro nome para o seu personagem')
        } else {
            nome = await useQuestion('Digite o nome do seu personagem')
        }

        nomeInvalido = false

        for (let i = 0; i < personagens.length; i++) {
            if (nome === personagens[i].nome) {
                nomeInvalido = true
            }
        }
    } while (nomeInvalido)

    return nome
}