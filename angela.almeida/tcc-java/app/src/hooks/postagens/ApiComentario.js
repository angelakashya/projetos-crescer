import  useAxios from '../axios/use-axios'


export function ApiComentario() {
    const usuario = JSON.parse(localStorage.getItem("user"))
    const config = {
        headers: {
            Authorization: usuario.token,
        }
      }

    const axiosInstance = useAxios('/privado/comentario', config.headers)

    function registrarComentario(comentario) {
        return axiosInstance.post('', comentario)
        
    }

    function obterComentarios(idPostagem) {
        return axiosInstance.get(`/${idPostagem}`)
    }

    return {
        registrarComentario,
        obterComentarios
    }
}