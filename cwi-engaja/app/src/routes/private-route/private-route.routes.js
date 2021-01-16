import React from 'react';
import { Route, Redirect } from 'react-router-dom';
import { useGlobalUser } from '../../context/usuario/usuario.context';

const PrivateRoute = ({ path, children }) => {

  const [ user ] = useGlobalUser();

  if(!user.token) {
    return <Redirect to='/login'/>
  }

  return (
    <Route path={path} exact>
      {children}
    </Route>
  )
}

export default PrivateRoute;
