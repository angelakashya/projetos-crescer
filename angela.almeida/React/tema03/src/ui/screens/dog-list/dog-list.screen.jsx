import React, { useState, useEffect } from 'react'
import { useDogApi } from '../../../hooks'
import './dog-list.css'


const dogApi = useDogApi()

export function DogListScreen() {
    const [dogs, setDogs] = useState([])
    console.log(dogs)
    const [quantidade, setQuantidade] = useState(1)

    useEffect(() => {
        async function obterDogs() {

            const dogs = await dogApi.obterDogs(quantidade)

            setDogs(dogs)
        }
    }, [quantidade])

    function criarnovoCachorro() {
        const novaQuantidade = 1

        setQuantidade(novaQuantidade)
    }

    return (
        <>
            <h1>Doguinhos</h1>
            {dogApi.map((dog, index)=> { 
                return <img src={dog}/>
            })}
            <button onClick={criarnovoCachorro}>Nova Imagem</button>
        </>
    )
}