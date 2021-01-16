import './App.css';
import { Dashboard, HomeScreen, RegisterScreen } from './ui/screens';
import { BrowserRouter, Switch, Route } from 'react-router-dom';

function App() {
  return (
    <>
      <BrowserRouter>

        <Switch>

          <Route path="/" exact>
            <HomeScreen />
          </Route>

          <Route path='/registro' exact>
            <RegisterScreen />
          </Route>

          <Route path='/dashboard' exact>
            <Dashboard />
          </Route>
          
        </Switch>
      </BrowserRouter>

    </>
  );
}

export default App;
