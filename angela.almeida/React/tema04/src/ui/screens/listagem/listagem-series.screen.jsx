import React from 'react'
import './style.css'
import { useState, useEffect } from 'react'
import { useSeriesApi } from '../../../hook'
import { CardSerie } from '../../components/series-cards/cards-list.component'
import { useParams } from 'react-router-dom'
import { CustomPagination } from '../../components/buttons/button-list.component'


function SerieList({ series }) {
    return series.filter(serie => serie.url).map(serie => (
        <img className="serie" key={serie.id} src={serie.image} alt={serie.name} />
    ))
}

const api = useSeriesApi()


export function Listagem() {
    const { paginaId } = useParams()
    const [series, setSeries] = useState([])
    const [pagina, setPagina] = useState([paginaId])

    useEffect(() => {
        async function obterSeries() {
            const series = await api.obterLista(paginaId)
            console.log(series.totalPages)
            setSeries(series)
            setPagina([series.currentPage])
        }

        obterSeries()
    }, [paginaId])



    return (
        <>
            <div className="teste">
                <div className="title">
                    <img src="https://fontmeme.com/permalink/201011/ca9b8f63bdf5298f40cb27b52cff19e2.png" alt="netflix-font" border="0" />
                </div>
                <div className="cards-list">
                    {(series.list || []).map(serie =>
                        <CardSerie key={serie.id} serie={serie} />)}
                </div>
                <CustomPagination value={series.totalPages}></CustomPagination>
            </div>
        </>
    )

}


