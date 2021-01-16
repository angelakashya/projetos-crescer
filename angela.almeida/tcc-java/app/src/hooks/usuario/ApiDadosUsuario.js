import useAxios from '../axios/use-axios'


export function ApiDadosUsuario() {
    const usuario = JSON.parse(localStorage.getItem("user"))
    const config = {
        headers: {
            Authorization: usuario.token,
        }
    }
    const axiosInstance = useAxios('/privado/', config.headers)

    function getId(id) {

        return axiosInstance.get(`/privado/usuario/${id}`)
    }

    async function listarNaoAmigo(idUsuario) {
        return await axiosInstance.get(`/usuario/pessoas/${idUsuario}`)
    }

    async function listarSolicitacoes(idUsuario) {
        return await axiosInstance.get(`/amigo/lista/amigo?idUsuario=${idUsuario}&aceito=true`)
    }

    return {
        listarNaoAmigo,
        listarSolicitacoes
    }
}