import React, { useState, useEffect } from 'react'

export function ExemploUseEffectAtualizacao() {
    const [instrutor, setInstrutor] = useState('Will')

    useEffect(() => {
        setInstrutor('Will')
    }, [instrutor])

    function handleMudarNomeClick() {
        setInstrutor('Gus')
    }

    return (
        <>
            <h1>Exemplo useEffect Atualizacao</h1>
            <p>{instrutor}</p>
            <button onClick={handleMudarNomeClick}>Mudar nome para Gus</button>
        </>

    )
}