import axios from 'axios'

const httpSeries = axios.create({
    baseURL: 'https://crescerflix.herokuapp.com/shows'
})

export function useSeriesApi() {

    async function obterLista(pagina) {
        const result = await httpSeries.get(`?page=${pagina}`)

        console.log(result.data.list)
        return result.data
    }

    async function obterSerie(id) {
        const result = await httpSeries.get(`/${id}`)

        return result.data
    }

    return {
        obterLista,
        obterSerie
    }

    
}
