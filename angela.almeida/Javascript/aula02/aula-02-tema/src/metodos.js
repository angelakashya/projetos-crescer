export function filtarPorAnoERetornarNome(series, ano) {
 let filtro;

 return(filtro = series.reduce((list, serie) => {
   if(serie.anoEstreia >= ano) list.push(serie.titulo)
   return list;
 }, []))

}

export function verificarSeAtorEstaEmSeriado(series, nomeAtor) {
    for (let i = 0; i < series.length; i++) {
        if(series[i].elenco.some((item) => item === nomeAtor)) return true;
    }

    return false;
}

export function calcularMediaTotalDeEpisodios(series) {
  return (
    series.reduce((ac, serie) => {
      return(ac += serie.numeroEpisodios)
    }, 0) / series.length
  )
}

export function agruparTituloDasSeriesPorPropriedade(series, propriedade) {
  const list = [];
  const obj = new Object();

  series.forEach(serie => {
    if (list.indexOf(serie[propriedade]) === -1) {
      list.push(serie[propriedade])
    }
  })

  const propriedadeAgrupada = list.sort()

  propriedadeAgrupada.forEach(propriedade => {
    obj[propriedade] = []
  })


  series.forEach(serie => {
    obj[serie[propriedade]].push(serie.titulo)
  })

  return obj
}
