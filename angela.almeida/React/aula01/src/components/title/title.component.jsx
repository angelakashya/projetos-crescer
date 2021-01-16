import React from 'react'
import './style.css'

export function Title({ nome, carregando, blue }) {
    let texto = `Olá ${nome}, bem vindo ao React`

    if (carregando) {
        texto = 'Carregando...'
    }

    return (
        <h1 className={blue && 'titulo'}>{texto}</h1>
    )
}


// Outras formas de fazer a mesma coisa:  
//
// export function Title(props) {
//   console.log(props.nome, props.outroValor, props.umObjetoPronto)

//   return (
//     <h1 className="titulo">Olá {props.nome}, bem vindo ao React</h1>
//   )
// }

// export function Title(props) {
//   const { nome, outroValor, umObjetoPronto } = props

//   console.log(nome, outroValor, umObjetoPronto)

//   return (
//     <h1 className="titulo">Olá {nome}, bem vindo ao React</h1>
//   )
// }
