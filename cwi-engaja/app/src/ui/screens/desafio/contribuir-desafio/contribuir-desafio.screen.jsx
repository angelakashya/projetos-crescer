import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { UseGlobalDesafio } from '../../../../context/desafio/desafio.context';
import { UseDesafioApi } from '../../../../hooks';
import ContribuirDesafioListCard from '../../../components/desafios-card/contribuir-desafio-card/contribuir-desafio-card.component';

export function ContribuirDesafio() {
  
  const [desafios, setDesafios] = useState([]);
  const desafioApi = UseDesafioApi();
  const [idDesafio] = UseGlobalDesafio();
  
  useEffect(() => {
    async function getDados() {
      const { data } =  await desafioApi.getDados()
      setDesafios(data)
      }
      getDados()
    }, [])

  return (
    <div>
      <Link to="/">Voltar</Link>
      <div className="div-cor">
          {<ContribuirDesafioListCard desafio={idDesafio}/>}
      </div>
  </div>
  );
}
