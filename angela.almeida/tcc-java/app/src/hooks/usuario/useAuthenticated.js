import {useCallback } from 'react'
import {useAxios } from '../axios/use-axios'
import {useGlobalUser} from '../../context/'

export const useAuthenticated = (baseUrl, apiFunctions) => {
    const [user] = useGlobalUser()
    const axiosInstance = useAxios(baseUrl, {authorization: user.token})

    const f = apiFunctions(axiosInstance)

    return useCallback({...f}, [])
}