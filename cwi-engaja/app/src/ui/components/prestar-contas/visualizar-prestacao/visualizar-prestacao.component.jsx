import React, { useState, useEffect } from "react"
import { UseDesafioApi } from "../../../../hooks"
import { ConfirmacaoAcao } from "../../confirmacao-acao/confirmacao-acao.component";

export function VisualizarPrestacao({ handleClose, isModalOpen, nomeDaMeta, idMeta }) {

  const prestarContasApi = UseDesafioApi();
  const [prestacao, setPrestacao] = useState([]);

  useEffect(() => {
    async function getDados() {
      const response = await prestarContasApi.visualizarPrestacaoContas(idMeta);
      setPrestacao(response.data);
    }
    getDados()
  }, [])

  return (
    <ConfirmacaoAcao
      bool = {true}
      prestacao={true}
      isModalOpen={isModalOpen}
      handleClose={handleClose}
      primeiraPalavra="Prestação de "
      segundaPalavra="contas"
      mensagemBotao="Clica no cancelar por enquanto kk"
      imagemPrestacao={prestacao.imagem}
      textoPrestacao={prestacao.descricao}
      descricao={`Prestação de contas sobre a recompensa: ${nomeDaMeta}.`
    }
    />
  )
}
