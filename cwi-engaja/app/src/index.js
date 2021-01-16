import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import { BrowserRouter } from 'react-router-dom';
import { UserProvider } from './context/usuario/usuario.context';
import { DesafioProvider } from './context/desafio/desafio.context';

ReactDOM.render(
    <BrowserRouter>
        <UserProvider>
            <DesafioProvider>
                <App />
            </DesafioProvider>
        </UserProvider>
    </BrowserRouter>,
    document.getElementById('root')
);
