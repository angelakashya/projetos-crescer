import React, { useState } from 'react';
import { Input } from '../../components';
import './login.style.css'
import { UserLogin } from '../../../hooks'
import { useHistory } from 'react-router-dom';
import { useGlobalUser } from '../../../context/usuario/usuario.context'
import Head from '../../components/helper/head';

const loginApi = UserLogin()

export function Login() {
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [, setUser] = useGlobalUser("")
    const history = useHistory()

    async function handleSubmit(event) {
        event.preventDefault();
        
        const response = await loginApi.login(username, password)
        const { token } = response.data
        setUser({ user: username, token });

        localStorage.setItem('user', JSON.stringify({ username, token }))

        history.push('/dashboard')
    }

    return (
        <>
            <Head title="Login" />
            <h3>Faça Login</h3>
            <form onSubmit={handleSubmit}>
                <Input
                    name="Username"
                    label="Usuário"
                    handleChange={setUsername}
                    value={username}
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
                <button>Entrar</button>

            </form>
        </>
    )
}