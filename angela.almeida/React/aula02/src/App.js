import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';

function App() {

  const [contador, setContador] = useState(0)


  console.log(setContador)


  function handleClick() {
    contador = contador + 1
    console.log(contador)
  }

  return (
    <div style={{ margin: 10 }}>
      Valor do meu contador: { contador}

      <button onClick={handleClick}>incrementar</button>
    </div>
  );
}

export default App;
