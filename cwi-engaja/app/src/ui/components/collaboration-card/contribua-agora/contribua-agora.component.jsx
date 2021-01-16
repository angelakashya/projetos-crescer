import React, { useState } from 'react';
import './contribua-agora.style.css'
import { useHistory } from 'react-router-dom';
import { UseDesafioApi } from '../../../../hooks';
import { makeStyles } from '@material-ui/core/styles';
import Select from '@material-ui/core/Select';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import { ConfirmacaoAcao } from '../../confirmacao-acao/confirmacao-acao.component';

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
  formControl: {
    minWidth: 320,
    "& label.Mui-focused": {
      color: "#333",
    },
    "& .MuiInput-underline:after": {
      borderBottomColor: "#FFB041"
    },
    "& .MuiOutlinedInput-root": {
      "& fieldset": {
        borderColor: "#FFB041",
        borderWidth: "2px"
      },
      "&:hover fieldset": {
        borderColor: "#FFB041"
      },
      "&.Mui-focused fieldset": {
        borderColor: "#FFB041",
      },
    }
  },
  selectEmpty: {
    marginTop: theme.spacing(2),
  },
}));

export function ContribuaAgora({ desafio }) {

  const desafioApi = UseDesafioApi();
  const navigation = useHistory()
  const [selectValue, setSelectValue] = useState(0);
  const [isModalOpen, setModalOpen] = useState(false);

  async function contribuir(idDesafio) {
    await desafioApi.contribuirDesafio(idDesafio, selectValue);
    navigation.push('/')
  }

  const classes = useStyles();

  function handleAbrirModal() {
    setModalOpen(true)
  }

  function handleCloseModal() {
    setModalOpen(false)
  }

  return (
    <div className="opcoes-contribuicao">
      {((desafio.opcaoContribuicao.length >= 1) ?
        <div className="input-mt">
          <FormControl variant="outlined" className={classes.formControl}>
            <InputLabel id="demo-simple-select-outlined-label">Opções de contribuição</InputLabel>
            <Select labelId="demo-simple-select-outlined-label" id="demo-simple-select-outlined" value={desafio.contribuicao} onChange={e => setSelectValue(e.target.value)}
              label="Opções de contribuição" required>
              {desafio?.opcaoContribuicao?.map((desafio, key) => {
                return (
                  <MenuItem key={key} value={desafio.contribuicao}>{desafio.contribuicao}</MenuItem>
                )
              })
              }
            </Select>
          </FormControl>
        </div>
        :
        <div></div>
      )}

      {(desafio.opcaoContribuicao.length > 1) ?
        <div className="btn">
          <button class="button" onClick={handleAbrirModal}>
            Contribuir
          </button>
        </div>
        :
        <div className="btn-sem-opcao">
          <button class="button" onClick={handleAbrirModal}>
            Contribuir
          </button>
        </div>
      }

      <ConfirmacaoAcao
        isModalOpen={isModalOpen}
        handleClose={handleCloseModal}
        onConfirm={() => contribuir(desafio?.id)}
        primeiraPalavra={"Contribuir"}
        segundaPalavra={"desafio"}
        descricao={"Ao clicar em “Contribuir desafio”, você terá ajudado a campanha!"}
        mensagemBotao={"Contribuir"}
      />
    </div>
  );
}
