import { UseAxios } from '../use-axios/use-api.hook'

export function UseDesafioApi() {
  const usuario = JSON.parse(localStorage.getItem("user"))
  const config = {
    headers: {
        Authorization: usuario.token,
    }
  }

  const axiosInstance = UseAxios('/private/desafio', config.headers)

  async function getDados() {
    return await axiosInstance.get('/listar')
  }

  async function contribuirDesafio(idDesafio, contribuicao) {
    return await axiosInstance.put('/contribuir', { "idDesafio": idDesafio, "contribuicao": contribuicao })
  }

  async function criarDesafio() {
    
  }

  return {
    getDados,
    contribuirDesafio
  }
}
