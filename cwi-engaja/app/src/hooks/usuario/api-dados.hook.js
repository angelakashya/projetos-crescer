import { UseAxios } from '../use-axios/use-api.hook'

export function UserProfile() {
    const usuario = JSON.parse(localStorage.getItem("user"))
    const config = {
        headers: {
            Authorization: usuario.token,
        }
    }

    const axiosInstance = UseAxios('/private', config.headers)

    async function getDados() {
        return await axiosInstance.get(`/me`)
    }

    return {
        getDados
    }
}
