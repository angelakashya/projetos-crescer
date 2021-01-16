import React, { useEffect, useState } from 'react';
import Head from '../../components/helper/head';
import './dashboard.style.css';
import { UseDesafioApi, UserProfile } from '../../../hooks/index';
import { Link } from 'react-router-dom';
import DesafioListCard from '../../components/desafios-card/desafios-card.component';

export function Dashboard() {

    const [usuario, setUsuario] = useState([]);
    const [desafios, setDesafios] = useState([]);

    const desafioApi = UseDesafioApi();
    const usuarioApi = UserProfile();

      useEffect(() => {
        async function getDados(){
          const { data } =  await usuarioApi.getDados()
          setUsuario(data)
        }
        getDados()
    }, [])

      useEffect(() => {
        async function getDados(){
          const { data } =  await desafioApi.getDados()
          setDesafios(data)
        }
        getDados()
    }, [])

    console.log(desafios)
    return (
      <>
        <Head title="Dashboard" />
        <section className="container-dashboard">
          <div className="itens">
            <p>{desafios?.id}</p>
            {
              desafios?.map((desafio, index)=> {
              return(
                <DesafioListCard key={index} desafio={desafio} />
              )
            })
            }

          </div>
          <div>
            <h3>{usuario.nome}</h3>
            <p>{usuario.nomeGestor}</p>
            <p>{usuario.posicao}</p>
          </div>
          <div>
            {((usuario.isGestor) || (usuario.isGlobal)) &&
              <div>
                <Link to='/criar-desafio'>Criar novo desafio</Link>
              </div>
            }
          </div>
        </section>
      </>
    );
  };