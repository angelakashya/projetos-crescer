import React from 'react'
import './desafio-not-found.style.css'
import { ReactComponent as FiguraNotFound } from '../../../../assets/img/figura-not-found-desafios.svg';

const DesafioNotFound = () => {

  return (
    <div className="container-not-found-desafio">
      <h2>
        Ooops! Ainda não tem <strong>desafios</strong>
      </h2>
      <p>Ainda não temos nenhum desafio criado!</p>
      <FiguraNotFound/>
    </div>
  )
}

export default DesafioNotFound;
