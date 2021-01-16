export async function buyItem(useQuestion, dinheiro, itens) {
    let dinheiroInsuficiente = false
    let itemInvalido = false

    do {
        console.clear()
        console.log('~$~$~$~$~$~$~Seja bem vindo a nossa loja!$~$~$~$~$~$~$')

        if (itemInvalido)
            console.log('Item selecionado não existe! Por favor selecione um item listado abaixo')
        else if (dinheiroInsuficiente)
            console.log('Você não tem dinheiro suficiente para esse item, selecione outro ou realize uma missão para conseguir mais dinheiro!')
        else
            console.log('Selecione o item que deseja comprar')

        itemInvalido = true
        dinheiroInsuficiente = true

        for (let i = 0; i < itens.length; i++) {
            console.log(`${itens[i].id}. ${itens[i].nome}`)
        }

        const idItem = parseInt(await useQuestion('Digite o numero do Item desejado ou digite 0 para voltar'))

        if (idItem === 0) {
            return null
        }

        for (let i = 0; i < itens.length; i++) {
            if (idItem === itens[i].id) {
                itemInvalido = false
                if (dinheiro >= itens[i].preco) {
                    dinheiroInsuficiente = false
                    return itens[i]
                }
            }
        }
    } while (itemInvalido || dinheiroInsuficiente)

}