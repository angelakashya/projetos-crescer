import  useAxios from '../axios/use-axios'


export function ApiRegistroUsuario() {

    const axiosInstance = useAxios()
    

    async function registrarUsuario(usuario) {
        const reponse = await axiosInstance.post('/publico/usuario/criar', usuario )
        return reponse.data;
    }

    return {
        registrarUsuario
    }
}