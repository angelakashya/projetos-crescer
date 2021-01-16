import React from 'react';
import './App.css';
//import { Switch, Route, Redirect } from 'react-router-dom'
import { Dashboard, Listagem } from './ui/screens'
import { Detalhes } from './ui/screens/detalhes/detalhe-serie.screen'
import { Switch, Route, Redirect } from 'react-router-dom'


function App() {
  return (
    <>
      <Switch>
        <Route path='/' exact>
          <Dashboard />
        </Route>
        <Route path='/lista/pagina/:paginaId'>
          <Listagem />
        </Route>
        <Route path='/detalhe/:id'>
          <Detalhes />
        </Route>
      </Switch>
    </>
  );
}

export default App;
