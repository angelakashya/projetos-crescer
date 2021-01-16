import axios from 'axios'

export function UseAxios(contextUrl, headers) {

    const baseUrl = contextUrl ? `${contextUrl}` : ''

    const instance = axios.create({
        baseURL: `http://cwi-engaja.cwi.com.br/api${baseUrl}`,
        headers,
    })

    return instance
}

export default UseAxios;
