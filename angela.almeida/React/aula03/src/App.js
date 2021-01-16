import React from 'react';
import logo from './logo.svg';
import './App.css';
import { ExemploUseEffectAtualizacao } from './ui/exemplo/exemplo-useeffect-atualizacao.component.jsx'
import { ExemploUserEffectDesmontagem } from './ui/exemplo/exemplo-useeffect-desmontagem.component.jsx'

function App() {
  return (
    <div>
      <ExemploUserEffectDesmontagem/>
      <button>Mostrar Exemplo?</button>
    </div>
  );
}

export default App;
