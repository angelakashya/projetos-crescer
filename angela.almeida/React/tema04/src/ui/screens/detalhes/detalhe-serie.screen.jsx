import React from 'react'
import { useParams } from 'react-router-dom'
import './style.css'
import { useSeriesApi } from '../../../hook'
import { useState, useEffect } from 'react'
import { CardSerie } from '../../components/detalhe-card/card-detalhe.component'

const api = useSeriesApi()

export function Detalhes() {
    const { id } = useParams()
    const [serie, setSerie] = useState([])

    useEffect(() => {
        async function obterSerieDetalhe() { 
            const serie = await api.obterSerie(id)

            setSerie(serie)
        }

        obterSerieDetalhe()
    })



    return (
        <>
            <CardSerie key={serie.id} serie={serie}/>
        </>
    )
}