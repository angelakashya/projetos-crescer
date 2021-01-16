import  useAxios from '../axios/use-axios'


export function ApiCurtida() {
    const usuario = JSON.parse(localStorage.getItem("user"))
    const config = {
        headers: {
            Authorization: usuario.token,
        }
      }

    const axiosInstance = useAxios('/privado/curtida', config.headers)

    function curtir(curtida) {
        return axiosInstance.post('', curtida)
        
    }

    function descurtir(id) {
        return axiosInstance.delete(`/${id}`)
    }

    function countByPost(id) {
        return axiosInstance.get(`/count/${id}`)
    }

    return {
        curtir,
        descurtir,
        countByPost
    }
}