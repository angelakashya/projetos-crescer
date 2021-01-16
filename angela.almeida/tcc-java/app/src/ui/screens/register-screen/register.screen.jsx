import React, { useState } from 'react'
import { useGlobalUser } from '../../../context/user-context/user.context'
import { ApiRegistroUsuario } from '../../../hooks/usuario/ApiRegistroUsuario'
import { Input } from '../../components/input/input.component'
import { Card } from '../../components/public-card-component/card.component'
import { useHistory } from 'react-router-dom'

import "./style.css"

const ApiRegistro = ApiRegistroUsuario()

export function RegisterScreen() {
    const [, setUser] = useGlobalUser()
    const [nomeCompleto, setNomeCompleto] = useState("")
    const [email, setEmail] = useState("")
    const [apelido, setApelido] = useState("")
    const [dataNascimento, setDataNascimento] = useState("")
    const [senha, setSenha] = useState("")

    const [error, setError] = useState()
    let hist = useHistory()


    async function handleSubmit(event) {
        event.preventDefault()

        try {
            const usuario = {
                nomeCompleto,
                email,
                apelido,
                dataNascimento: dataNascimento.split('-').reverse().join('/'),
                senha
            }

            const response = await ApiRegistro.registrarUsuario(usuario)
            setUser(response)
        } catch (error) {
            setError("Algo de errado aconteceu")
        }
    }



    return (
        <div className="main-container-register">
            <div className="logo">
                <img src="https://fontmeme.com/permalink/201121/177fd26b76907561350fab194e4ceacb.png" alt="fancy-fonts" border="0"></img>
            </div>
            <div className="container">
                <Card title="">
                    <div className="title">
                        <h3>Registre-se</h3>
                        <form className="login-form-item" onSubmit={handleSubmit}>
                            <Input
                                type="text"
                                name="NomeCompleto"
                                label="Nome Completo"
                                handleChange={setNomeCompleto}
                                value={nomeCompleto}
                                required />

                            <Input
                                type="email"
                                name="Email"
                                label="Email"
                                handleChange={setEmail}
                                value={email}
                                required />

                            <Input
                                name="Apelido"
                                label="Apelido(Opcional)"
                                handleChange={setApelido}
                                value={apelido}
                                required />

                            <Input
                                type="date"
                                name="DataNascimento"
                                label="Data de Nascimento"
                                handleChange={setDataNascimento}
                                value={dataNascimento}
                                required />

                            <Input
                                type="password"
                                name="Senha"
                                label="Senha"
                                handleChange={setSenha}
                                value={senha}
                                required />
                            <button className="btn">Registrar</button>
                        </form>
                    </div>
                </Card>
            </div>
        </div>
    )
}