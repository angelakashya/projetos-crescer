import React, { useState } from 'react';
import Head from '../../../components/helper/head';
import './desafio.style.css';

export function Desafio() {
  const [desafio, setDesafio] = useState([])
  const [acao, setACao] = useState([])
  const [error, setError] = useState()

  const usuario = JSON.parse(localStorage.getItem("user"))

  async function handleSubmitDesafio(event) {
    event.preventDefault()

    try {
      const desafio = {
        // texto,
        // imagem,
        // idUsuario: {
        //   id: usuario.id
        // }
      }

      // await CriarDesafio().registrarPostagem(desafio)
      // setACao([])
    } catch (error) {
      setError("Algo de errado aconteceu")
    }
  }

  return (
    <>
      <Head title="Criar desafio" />
      <section className="container-desafio">
        <h1>TESTE DESAFIO</h1>
      </section>
    </>
  );


};


