import React from 'react';
import './confirmacao-acao.style.css';
import { Dialog } from '@material-ui/core';

export function ConfirmacaoAcao({ handleClose, isModalOpen, onConfirm, primeiraPalavra, segundaPalavra,
  descricao, mensagemBotao, children, bool, prestacao, imagemPrestacao, textoPrestacao }) {

  function handleConfirm() {
    onConfirm()
  }

  function handleCancel() {
    handleClose()
  }

  return (
    <>
      <Dialog open={isModalOpen} maxWidth="725px">
        <div className={bool ? "container-modal-prestacao" : "container-modal"}>
          {prestacao ?
            <div className="prestacao-visualizacao">
              <div className="posicionar-botao">
                <button onClick={handleCancel} className="bt-sair">Sair</button>
              </div>
              <div className="titulo-modal">
                <p>{primeiraPalavra} <strong>{segundaPalavra}</strong></p>
              </div>
              <div className="desc-modal">
                {descricao}
              </div>
              <img src={imagemPrestacao} alt="Prestação de contas" />
              <div className="texto-prestacao">
                <p>{textoPrestacao}</p>
              </div>
            </div>
            :
            <div>
              <div className="titulo-modal">
                <p>{primeiraPalavra} <strong>{segundaPalavra}</strong></p>
              </div>
              <div className="desc-modal">
                {descricao}
              </div>
              <div>
                {children}
              </div>
              <div className="botoes-modal">
                <button onClick={handleCancel} className="bt-cancel">Cancelar</button>
                <button onClick={handleConfirm} className="button bt-aceitar">{mensagemBotao}</button>
              </div>
            </div>
          }
        </div>
      </Dialog>
    </>
  )
}
