import React from 'react'
import { Link } from 'react-router-dom'
import './style.css'
import { Avaliacao } from '../rating/avaliacao.component'


export function CardSerie({ serie }) {

    return (
        <div className="container-list">
            <div className="detalhes">
                <div className='serieName'>
                    <span>{serie.name}</span>
                </div>
                <Link to={`/detalhe/${serie.id}`}>
                    <img src={serie.image.medium} />
                </Link>
                <div className="rating">
                    <Avaliacao value={serie.rating}></Avaliacao>
                </div>
            </div>
        </div>
    )
}