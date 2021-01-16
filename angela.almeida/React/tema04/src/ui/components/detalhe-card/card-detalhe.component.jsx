import React from 'react'
import { Link } from 'react-router-dom'
import './style.css'
import { Avaliacao } from '../rating/avaliacao.component'

export function CardSerie({ serie }) {

    return (
        <div className="container">
            <img src={serie.image?.medium} alt={serie.name} />
            <div className="divisao">
                <div className="name">
                    <span>{serie.name}</span>
                </div>
                <div>
                    <div className="rating">
                        <Avaliacao value={serie.rating}></Avaliacao>
                    </div>
                    <div className="summary">
                        <span>{serie.summary}</span>
                    </div>
                    <div className="genres">
                        <ul>
                            {(serie.genres || []).map((genre, index) =>
                                <li key={`gen ${index}`}>{genre}</li>
                            )}
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    )
}
