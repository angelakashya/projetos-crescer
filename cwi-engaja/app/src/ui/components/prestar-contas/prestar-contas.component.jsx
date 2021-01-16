import React, { useState } from "react"
import { DropzoneArea } from 'material-ui-dropzone'
import './style.css'
import { UseDesafioApi } from "../../../hooks"
import { ConfirmacaoAcao } from "../confirmacao-acao/confirmacao-acao.component";

export function PrestarContas({ handleClose, isModalOpen, nomeDaMeta, idDesafio, idMeta }) {

  const prestarContasApi = UseDesafioApi();
  const [descricao, setDescricao] = useState(null)
  const [base64, setBase64] = useState(null)
  const reader = new FileReader()

  reader.onloadend = function (event) {
    setBase64(event.target.result)
  }

  function handleTextChange(e) {
    e.preventDefault()
    setDescricao(e.target.value)
  }

  function handleFileChange(arquivo) {
    if (arquivo[0]) {
      setBase64(reader.readAsDataURL(arquivo[0]))
    }
  }

  async function prestarContas() {
    const body = {
      idMeta,
      foto: base64,
      descricao: descricao
    }
    const response = await prestarContasApi.prestarContas(idDesafio, body)
    if (response.status === 200) {
      window.alert("Prestação de contas enviada!")
      handleClose()
    }
  }

  return (
    <ConfirmacaoAcao
      bool={true}
      isModalOpen={isModalOpen}
      handleClose={handleClose}
      primeiraPalavra="Prestar"
      segundaPalavra="contas"
      mensagemBotao="Enviar"
      descricao={`Prestar contas sobre a recompensa: ${nomeDaMeta}. Você pode adicionar uma imagem e/ou escrever um texto.`}
      onConfirm={prestarContas}>
      <DropzoneArea
        filesLimit={1}
        dropzoneText="Adicione sua imagem!"
        dropzoneClass={"drop-zone"}
        acceptedFiles={['image/jpeg', 'image/png']}
        maxFileSize={2000000}
        fullWidth={false}
        maxHeight="68px"
        onChange={loadedFiles => handleFileChange(loadedFiles)}
        showPreviews={false}
        showFileNames={true}
      />
      <textarea className="texto-livre" placeholder="Escreva algo legal aí ;)" rows="8" onChange={handleTextChange}></textarea>
    </ConfirmacaoAcao>
  )
}
