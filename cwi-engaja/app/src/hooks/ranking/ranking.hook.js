import { UseAxios } from '../use-axios/use-api.hook'

export function UseRankingApi() {
  const usuario = JSON.parse(localStorage.getItem("user"))
  const config = {
    headers: {
      Authorization: usuario?.token,
    }
  }

  const axiosInstance = UseAxios('/private/ranking', config.headers)

  async function getDados() {
    try {
      return await axiosInstance.get()
    } catch(error) {
      return error.response.data
    }
  }

  return {
    getDados
  }
}
