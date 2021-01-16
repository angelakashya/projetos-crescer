import React from 'react'
import './ranking-list-card.style.css'

const RankingListCard = ({ ranking, bool }) => {

  const numero = Math.floor(Math.random() * (99 - 1 + 1)) + 1;
  const generos = ['men', 'women'];
  const genero = generos[Math.round(Math.random() * (generos.length - 1))];

  return (
    <div className="user-ranking">
      {bool ?
        <img className="img-clipboard" src={`https://randomuser.me/api/portraits/med/${genero}/${numero}.jpg`} alt="Foto do usuário" />
        :
        <img className="img-ranking" src={`https://randomuser.me/api/portraits/med/${genero}/${numero}.jpg`} alt="Foto do usuário" />
      }
      <p>{ranking.nome}</p>
    </div>
  )
}

export default RankingListCard;
