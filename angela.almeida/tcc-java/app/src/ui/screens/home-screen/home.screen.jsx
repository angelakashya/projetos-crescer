import React, { useState } from 'react'
import { Card } from '../../components'
import { Link, useHistory } from 'react-router-dom'
import "./style.css"
import { userAuth } from '../../../hooks/usuario/ApiLoginUsuario'
import { Input } from '../../components/input/input.component'
import { useGlobalUser } from '../../../context/user-context/user.context'

const authApi = userAuth()

export function HomeScreen() {
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [, setUser] = useGlobalUser()
    const history = useHistory()

    async function handleSubmit(event) {
        event.preventDefault();

        const response = await authApi.login(email, password)
        const { token, id, nomeCompleto, imagem, apelido} = response.data
        setUser({ email, token, id, nomeCompleto, imagem, apelido });

        localStorage.setItem("user", JSON.stringify({ email, token, id, nomeCompleto, imagem, apelido }))

        history.push('/dashboard')
    }


    return (

        <div className="main-container">
            <div className="logo">
                <img src="https://fontmeme.com/permalink/201121/177fd26b76907561350fab194e4ceacb.png" alt="fancy-fonts" border="0"></img>
            </div>
            <div className="container">
                <Card title="">
                    <div className="title">
                        <h3>Faça Login</h3>
                        <form className="login-form-item" onSubmit={handleSubmit}>
                            <Input
                                name="Email"
                                label="Email"
                                handleChange={setEmail}
                                value={email}
                                required
                            />

                            <Input
                                type="password"
                                name="password"
                                label="Senha"
                                handleChange={setPassword}
                                value={password}
                                required
                            />
                            <button className="btn-login">Logar</button>
                        </form>
                        <div className="toRegister">
                            <p>Ainda não é cadastrado?</p>
                            <Link to="/registro">
                                Registre-se
                            </Link>

                        </div>
                    </div>

                </Card>
            </div>
        </div>
    )
}