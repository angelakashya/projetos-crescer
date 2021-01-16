import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import { Login, NotFound, Dashboard, Desafio, ContribuirDesafio } from '../ui/screens'
import PrivateRoute from './private-route/private-route.routes';

const Routes = () => {
  return (
    <BrowserRouter>
      <Switch>
        <Route path='/' exact>
          <Login />
        </Route>

        <PrivateRoute path='/dashboard'>
          <Dashboard/>
        </PrivateRoute>

        <PrivateRoute path='/criar-desafio' exact>
          <Desafio/>
        </PrivateRoute>
        
        <PrivateRoute path='/contribuir-desafio' exact>
          <ContribuirDesafio/>
        </PrivateRoute>
        
        <Route path='*'>
          <NotFound />
        </Route>

      </Switch>
    </BrowserRouter>
  )
}

export default Routes;