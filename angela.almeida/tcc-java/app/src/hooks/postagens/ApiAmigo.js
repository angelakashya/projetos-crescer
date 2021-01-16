import  useAxios from '../axios/use-axios'


export function ApiAmigo() {
    const usuario = JSON.parse(localStorage.getItem("user"))
    const config = {
        headers: {
            Authorization: usuario.token,
        }
      }

    const axiosInstance = useAxios('/privado/amigo', config.headers)

    function solicitarAmizade(amigo) {
        return axiosInstance.post('', amigo)
        
    }

    return {
        solicitarAmizade,
    }
}