import { useQuestion } from './src/services/question/use-question'
import { useLocalStorage } from './src/services/local-storage/use-local-storage'
import { mainMenu } from './src/menus/main-menu'

const main = async () => {
  // const localStorage = useLocalStorage()
  // const nome = await useQuestion('Qual o seu nome?')

  // localStorage.setString('nome-string', nome)
  // localStorage.setObject('nome-obj', { nome })

  // console.log(localStorage.getString('nome-string'))
  // console.log(localStorage.getObject('nome-obj'))

  mainMenu();
}

main()