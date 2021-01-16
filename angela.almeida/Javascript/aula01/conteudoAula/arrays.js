const numeros = [1, 2, 3, 4, 5, 'teste', true]
numeros[0] = 'outra coisa'

for(let i =0; i < numeros.length; i++) {
    console.log(numeros[i])
}