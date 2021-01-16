import  useAxios from '../axios/use-axios'


export function ApiPostagem() {
    const usuario = JSON.parse(localStorage.getItem("user"))
    const config = {
        headers: {
            Authorization: usuario.token,
        }
      }

    const axiosInstance = useAxios('/privado/postagem', config.headers)

    function registrarPostagem(postagem) {

        return axiosInstance.post('', postagem)
        
    }

    function obterPostagens() {
        return axiosInstance.get()
    }

    return {
        registrarPostagem,
        obterPostagens
    }
}