import { Table, TableContainer, TableRow, TableCell, TableBody } from "@material-ui/core"
import { withStyles } from '@material-ui/core/styles';
import React, { useEffect, useState } from "react"
import { useParams } from "react-router-dom"
import IlustracaoResultados from '../../../assets/img/figura-listar-detalhes-desafio.svg'
import { UseDesafioApi } from "../../../hooks"
import RankingListCard from '../../components/ranking-list-card/ranking-list-card.component';
import { CopyToClipboard } from 'react-copy-to-clipboard';
import { ReactComponent as CopiarIcon } from '../../../assets/img/copy.svg'
import './style.css'

const StyledTableCell = withStyles((theme) => ({
  root: {
    borderBottom: "none",
    margin: "0px",
    marginBottom: "8px",
    padding: "0px",
    textAlign: "left"
  },
}))(TableCell);

export function ResultadosDesafio({ desafio }) {

  const desafioApi = UseDesafioApi()
  const [resultados, setResultados] = useState([])
  const [textoCopia, setTextoCopia] = useState(null)
  const [copiado, setCopiado] = useState(false)
  const [isCarregando, setIsCarregando] = useState(true)
  const { id } = useParams()

  useEffect(() => {
    async function getResultados() {
      const response = await desafioApi.getResultados(id)
      if (response.status === 200) {
        prepararTextoCopia(response.data)
        setResultados(response.data)
        setIsCarregando(false)
      } else {
        window.alert("Desculpe, ocorreu um erro!")
      }
    }

    getResultados()
  }, [])

  function prepararTextoCopia(data) {
    let texto = 'Nome\tContribuição\n'
    data.map(value => {
      texto = texto.concat(`${value.nome}\t${value.contribuicao || 1}\n`)
    })
    setTextoCopia(texto)
  }

  if (isCarregando) {
    return "Carregando..."
  }

  return (
    <div className="container-resultado-desafio">
      <div className="container-tabela-resultados">
        <div className="container-resultado">
          <div className="container-header-tabela">
            <h1 className="titulo-tabela">Resultado do <strong className="strong-titulo">desafio</strong></h1>
            <CopyToClipboard
              text={textoCopia}
              onCopy={() => setCopiado(true)}
              options={{
                message: "Teste!"
              }
              }>
              <button className="button bt-clipboard">
                {copiado
                  ? <span className="texto-copiar">Dados copiados!</span>
                  :
                  <span className="texto-copiar"><CopiarIcon /> Copiar dados</span>
                }
              </button>
            </CopyToClipboard>
          </div>

          <div className="container-resultados">
            <TableContainer>
              <Table>
                <TableBody className="corpo-tabela">
                  {resultados.map((value, index) => {
                    return (
                      <>
                        <TableRow>
                          <StyledTableCell>
                            <RankingListCard ranking={value} bool={true} />
                          </StyledTableCell>
                          <StyledTableCell align="right">
                            {value.contribuicao ? `Opção ${value.contribuicao}` : ""}
                          </StyledTableCell>
                        </TableRow>
                      </>
                    )
                  })}
                </TableBody>
              </Table>
            </TableContainer>
          </div>
        </div>
      </div>
      <img src={IlustracaoResultados} />
    </div>
  )
}
