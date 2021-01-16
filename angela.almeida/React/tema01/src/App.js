import React from 'react';
import './App.css'
import vingadores from './cards-heroi'
import { Card } from './components/card/card.component.jsx'

function App() {

  return (
    

    <div>
      {vingadores.map(item => {
        return <Card>{item}</Card>
      })}

    </div>
  );


}

export default App;
