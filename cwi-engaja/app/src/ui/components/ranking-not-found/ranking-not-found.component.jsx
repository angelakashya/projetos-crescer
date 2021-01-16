import React from 'react'
import './ranking-not-found.style.css'
import { ReactComponent as FiguraNotFoundRanking } from '../../../assets/img/figura-not-found-ranking.svg';

const RankingNotFound = () => {

  return (
    <div className="container-not-found-ranking">
      <div className="bg-figura-ranking-not-found">
        <FiguraNotFoundRanking />
      </div>
      <h2>
        Seja o <strong>primeiro</strong> a contribuir e faça parte desse ranking.
      </h2>
    </div>
  )
}

export default RankingNotFound;
