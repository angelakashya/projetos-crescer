import React from 'react';
import TextField from "@material-ui/core/TextField";
import './login-input.style.css'
import { makeStyles, withStyles } from '@material-ui/core/styles';

const useStyles = makeStyles(theme => ({
  modal: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
  },
  paper: {
    backgroundColor: theme.palette.background.paper,
    border: '2px solid #000',
    boxShadow: theme.shadows[5],
    padding: theme.spacing(2, 4, 3),
  },
  selectEmpty: {
    marginTop: theme.spacing(2),
  },
}));

const CssTextField = withStyles({
  root: {
    '& label.Mui-focused': {
      color: '#333',
    },
    '& .MuiInput-underline:after': {
      borderBottomColor: "#FFB041"
    },
    '& .MuiOutlinedInput-root': {
      '& fieldset': {
        borderColor: "#333",
        borderWidth: "2px",
      },
      '&:hover fieldset': {
        borderColor: "#FFB041",
      },
      '&.Mui-focused fieldset': {
        borderColor: "#FFB041",
      },
    },
  },
})(TextField);

export default function LoginInput({ formState, onChange }) {

  const classes = useStyles();

  return (
    <>
      <div className="primeiro-input">
        <CssTextField
          className={classes.margin}
          label="Usuário"
          variant="outlined"
          id="username"
          value={formState.username}
          onChange={onChange}
          fullWidth
          required
        />
      </div>

      <CssTextField
        className={classes.margin}
        label="Senha"
        variant="outlined"
        id="password"
        type="password"
        value={formState.password}
        onChange={onChange}
        fullWidth
        required
      />
    </>
  )
}
