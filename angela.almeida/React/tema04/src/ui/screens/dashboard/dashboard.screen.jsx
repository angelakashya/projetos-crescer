import React from 'react'
import { Listagem } from '../listagem/listagem-series.screen'
import './style.css'
import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'


export function Dashboard() {

    return (
        <div className="container-dash">
            <div className='img'>
                <img src="https://fontmeme.com/permalink/201010/1efb73e747aa1115b55e26df83351b76.png" alt="netflix-font" border="0" />
            </div>
            <Link to="/lista/pagina/1">
                <button className="button-dash">Séries</button>
            </Link>
        </div>
    )

}