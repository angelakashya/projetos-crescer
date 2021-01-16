import { UseAxios } from '../axios/use-axios'

const axiosInstance = UseAxios()

export function userAuth() {

  function login(email, password) {
    return axiosInstance.post('/publico/usuario/autenticar', { email, password })
  } 

  return {
    login
  }
}
