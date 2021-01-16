const instrutor = { 
    nome: "Will",
    idade: 23,
    cidade: 'Sapucaia'
}

const outroInstrutor = { 
    nome: 'Gus',
    dataNascimento: new Date(),

    filhos: [
        {
            nome: 'Luan',
        },
        {
            nome: 'Will'
        }
    ]
}

const parametro = 'nome';
console.log(outroInstrutor.filho.nome)