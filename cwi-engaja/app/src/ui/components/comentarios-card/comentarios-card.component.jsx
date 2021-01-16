import React from 'react'
import UserDefault from '../../../assets/img/user-default.png';

const ComentarioListCard = ({ comentario }) => {

  const generos = ['men', 'women'];
  const genero = generos[Math.round(Math.random() * (generos.length - 1))];
  const numero = Math.floor(Math.random() * (99 - 1 + 1)) + 1;

  return (
    <div>
      <div className="card-comentario">
        <div>
          <img src={`https://randomuser.me/api/portraits/med/${genero}/${numero + 5}.jpg` ? `https://randomuser.me/api/portraits/med/${genero}/${numero + 5}.jpg` : UserDefault}
            alt="Foto do usuário" />
          <div class="info-usuario">
            <p>{comentario?.usuario}</p>
            <span>{comentario?.dataCadastro}</span>
          </div>
        </div>
        <div className="comentario-texto">
          <p>{comentario?.mensagem}</p>
        </div>
      </div>
    </div>
  )
}

export default ComentarioListCard;
