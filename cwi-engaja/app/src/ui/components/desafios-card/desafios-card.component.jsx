import React from 'react'
import './desafios-card.style.css'
import { useCallback } from 'react'
import { useHistory } from 'react-router-dom'
import { UseDesafioApi } from '../../../hooks/index';
import { UseGlobalDesafio } from '../../../context/desafio/desafio.context';

const DesafioListCard = ({desafio}) => {
    const [idDesafio, setIdDesafio] = UseGlobalDesafio();
    const desafioApi = UseDesafioApi();
    const navigation = useHistory()

    const onClick = useCallback(()=>{
      setIdDesafio(desafio)
      navigation.push('/contribuir-desafio')
    },[navigation])

  console.log(desafio)
    return(
        <div>
        {((desafio.status === "ATIVO")) &&
          <div>   
            <div>
              <h2>{desafio?.titulo}</h2>
              <div>
                <span>Descricaco {desafio?.descricao}</span><br/>
                <span>Data limite {desafio?.dataLimite}</span><br/>
                <span>Desafio by {desafio?.usuario?.nome}</span><br/>
                <span>Qtd. participantes {desafio?.quantidadeParticipantes}</span><br/>
                <span>ID {desafio?.id}</span><br/>
                <span>Desafio {desafio?.tipoDesafio}</span><br/>
              </div>
            </div>
            <button onClick={onClick}>
              Aceitar participar do desafio
            </button>
          </div>
        }
      </div>
    )
  }

  export default DesafioListCard;
