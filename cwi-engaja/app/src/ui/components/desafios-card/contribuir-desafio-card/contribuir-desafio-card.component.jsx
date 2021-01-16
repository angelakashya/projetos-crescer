import React, { useState } from 'react'
import './contribuir-desafio-card.style.css'
import { useCallback } from 'react'
import { useHistory } from 'react-router-dom'
import { UseDesafioApi } from '../../../../hooks/index';
import { UseGlobalDesafio } from '../../../../context/desafio/desafio.context';

const ContribuirDesafioListCard = ({desafio}) => {
    const desafioApi = UseDesafioApi();
    const navigation = useHistory()
    const [idDesafio, setIdDesafio] = UseGlobalDesafio();
    console.log(idDesafio)
    const [selectValue, setSelectValue] = useState(10);  

    async function contribuir(idDesafio) {
      const contribuir = await desafioApi.contribuirDesafio(idDesafio, selectValue);
      navigation.push('/')
  }

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
                <label for="contribuicao">Opçao contribuiçao</label>
                <p>{selectValue}</p>
                <select id="contribuicao" value={selectValue} onChange={e => setSelectValue(e.target.value)}>
                  {
                    desafio?.opcaoContribuicao?.map((desafio)=> {
                    return(
                      <option value={desafio.contribuicao}>{desafio.contribuicao}</option>
                    )})
                  }
                </select>
              </div>
            </div>
            <button onClick={()=>contribuir(desafio?.id, desafio.opcaoContribuicao?.contribuicao)}>
              Doar
            </button>
          </div>
        }
      </div>
    )
  }

  export default ContribuirDesafioListCard;
