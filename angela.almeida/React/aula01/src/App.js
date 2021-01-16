import React from 'react';
import { Title, Card } from './components'

function App() {
  const nomeInstrutor = 'Gus'
  const carregando = true

  return (
    <>
      <Title nome="Will" blue />

      <Card>
        <Title nome={nomeInstrutor} carregando={carregando} blue />
        <Title nome={nomeInstrutor} />
      </Card>
    </>

  );
}

export default App;