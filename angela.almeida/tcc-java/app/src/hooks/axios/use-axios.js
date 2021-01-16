import axios from 'axios'

export function UseAxios(contextUrl, headers) {

    const baseUrl = contextUrl ? `${contextUrl}` : ''

    const instance = axios.create({
        baseURL: `http://localhost:8090/tcc-java${baseUrl}`,
        headers,
    })

    return instance
}

export default UseAxios;