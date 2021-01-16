
const operacao = ""
const valores = []

function calcular(operacao, valores) { 
    let result = valores[0]
    switch (operacao) {
        case 'soma':
            for (let i = 1; i < valores.length; i++) {
               result += valores[i]
            }
            return result
        case 'subtracao':
            for (let i = 1; i< valores.length; i++) {
              result -= valores[i]
            }
            return result
        case 'multiplicacao':
            for (let i = 1; i < valores.length; i++) {
                result *= valores[i]
            }
            return result; 
        case 'divisao':
            for (let i = 1; i < valores.length; i++) {
                const element = valores[i];
                    result /= valores[i]
            }
            return result
        default:
            return 'OPERAÇÃO INVALIDA'
    }
        
}

const tresMaisQuatro = calcular("soma", [3, 4])
console.log(tresMaisQuatro) // 7

const cincoMenosDoisMenosUm = calcular("subtracao", [5, 2, 1])
console.log(cincoMenosDoisMenosUm) // 2

const doisVezesCinco = calcular("multiplicacao", [2, 5])
console.log(doisVezesCinco) //10

const quatroDivididoPorDois = calcular("divisao", [4, 2])
console.log(quatroDivididoPorDois)

const operacaoInexistente = calcular("somaeeee", [10, 12])
console.log(operacaoInexistente)
