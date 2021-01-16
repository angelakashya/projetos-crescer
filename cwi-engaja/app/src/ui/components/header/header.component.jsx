import React, { useEffect, useState } from 'react';
import './header.style.css';
import { Link, useHistory } from 'react-router-dom';
import { UserProfile } from '../../../hooks/index';
import { Button, Menu, MenuItem } from '@material-ui/core';
import UserDefault from '../../../assets/img/user-default.png';
import { ReactComponent as Logo } from '../../../assets/img/logo.svg';

const Header = () => {

  const [usuario, setUsuario] = useState([]);
  const usuarioApi = UserProfile();
  const navigation = useHistory();
  const numero = Math.floor(Math.random() * (99 - 1 + 1)) + 1;
  const generos = ['men', 'women'];
  const genero = generos[Math.round(Math.random() * (generos.length - 1))];

  useEffect(() => {
    async function getDados() {
      const { data } = await usuarioApi.getDados()
      setUsuario(data)
    }
    getDados()
  }, [])

  function onClick() {
    setUsuario({})
    localStorage.setItem('user', null)
    navigation.push('/login');
  }

  const [anchorEl, setAnchorEl] = useState(null);

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null)
  }

  return (
    <header className="header">
      <div className="nav">
        <Link className="logo" to="/">
          <Logo />
        </Link>
      </div>
      <div className="usuario">
        <h2>{usuario.nome}</h2>
        <Button aria-controls="simple-menu" aria-haspopup="true" onClick={handleClick}>
          <img src={`https://randomuser.me/api/portraits/med/${genero}/${numero}.jpg` ?
          `https://randomuser.me/api/portraits/med/${genero}/${numero}.jpg` : UserDefault} alt="Foto do usuário" />
        </Button>
        <Menu
          className="simple-menu"
          id="simple-menu"
          anchorEl={anchorEl}
          keepMounted
          open={Boolean(anchorEl)}
          onClose={handleClose}>
          <MenuItem onClick={onClick}>Sair</MenuItem>
        </Menu>
      </div>
    </header>
  );
};

export default Header;
