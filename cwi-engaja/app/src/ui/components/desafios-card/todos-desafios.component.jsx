import React from 'react'
import './desafios-card.style.css'
import { useCallback } from 'react'
import { useHistory } from 'react-router-dom'

const TodosDesafiosListCard = ({ desafio }) => {

  const navigation = useHistory()

  const onClick = useCallback(() => {
    navigation.push(`/detalhes/desafio/${desafio.id}`)
  }, [navigation]);

  function calcularPorcentagem(quantidadeParticipantes, quantidadeColaboradores) {
    const calculo = (quantidadeParticipantes / quantidadeColaboradores) * 100;
    if (calculo > 100) return 100;
    else if (calculo === 0) return 0;
    else if (calculo < 6) return 6;
    else return Math.round(calculo);
  }

  return (
    <div>
      {!desafio.isAtivo &&
        <button className="card-desafio" onClick={onClick}>
          <div>
            <div className="separacao-card--desafio">
              <div className="texto-card--desafio encerrado">
                <h1>{desafio?.titulo}</h1>
                <div className="data-card--desafio encerrado">
                  <h3>{desafio?.dataLimite}</h3>
                  <p>Finalizado</p>
                </div>
              </div>
              {desafio?.jaContribuiu === true &&
                <div className="texto-contribuicao">
                  <p>Parabéns, você contribuiu com esse desafio!</p>
                </div>
              }
            </div>
            <div>
              {desafio.metas?.map((meta, k) => (
                <div key={k} className="metas--desafio">
                  <div className="progressao">
                    <div className="progressao-meta">
                      {
                        calcularPorcentagem(desafio.quantidadeParticipantes, meta.quantidadeColaboradores) === 0 ? <p></p> :
                          <div className="progressao-meta--feita progresso-encerrado" style={{ width: `${calcularPorcentagem(desafio.quantidadeParticipantes, meta.quantidadeColaboradores)}%` }}>
                            {desafio.quantidadeParticipantes}
                          </div>
                      }
                    </div>
                    <h2 className="texto-h2 encerrado">
                      {Math.round((desafio.quantidadeParticipantes / meta.quantidadeColaboradores) * 100) <= 100 ? calcularPorcentagem(desafio.quantidadeParticipantes, meta.quantidadeColaboradores) : 100}
                      <span className="texto-span encerrado">%</span></h2>
                  </div>
                  <div className="texto-meta">
                    {meta.recompensa}
                  </div>
                </div>
              ))}
            </div>
          </div>
        </button>
      }
    </div>
  )
}

export default TodosDesafiosListCard;