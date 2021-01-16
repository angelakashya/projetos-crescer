import { UseAxios } from '../use-axios/use-api.hook'

const axiosInstance = UseAxios()

export function UserLogin() {

  function login(user, password) {
    return axiosInstance.post('/public/login', { user, password })
  } 

  return {
    login
  }
}
