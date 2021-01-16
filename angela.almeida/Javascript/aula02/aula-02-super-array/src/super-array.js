export const SuperArray = (...itens) => {

  const array = {
    /**
     * Propriedade para acessar os itens
     */

    itens: [...itens],
  }

  /**
   * Adicionar um novo item ao final dos items
   */

  array.push = item => {
    array.itens[array.itens.length] = item;
  }

  /**
   * Itera sobre cada um dos elementos do SuperArray enviando o item e o index
   * como segundo parametro
   */

  array.forEach = callback => {
    for (let i = 0; i < array.itens.length; i++) {
      const element = array.itens[i];
      callback(element);
    }
  },

    /**
     * Retorna um novo SuperArray com os itens mapeados
     */

    array.map = callback => {
      const newArray = new SuperArray();

      for (let i = 0; i < array.itens.length; i++) {
        const item = array.itens[i];
        newArray.itens[i] = callback(item);
      }

      return newArray;
    }


  /**
   * Retorna um SuperArray novo com os itens filtrados
   */

  array.filter = callback => {
    const instrutoresDandoAula = new SuperArray();
    let count = 0;

    for (let i = 0; i < array.itens.length; i++) {
      const item = array.itens[i];

      if (callback(item))
        instrutoresDandoAula.itens[count++] = item;
    }

    return instrutoresDandoAula;
  }


  /**
   * Retorna o primeiro elemento do SuperArray que satisfazer o callback recebido
   * se não encontrar, deve retornar undefined
   */

  array.find = callback => {
    for (let i = 0; i < array.itens.length; i++) {
      const item = array.itens[i];

      if(callback(item))
        return item;
    }
  }

  /**
   * Reduz o SuperArray em um único valor
   */


  array.reduce = (callback, valorInicial) => {
    for (let i = 0; i < array.itens.length; i++) {
      const element = array.itens[i];
      valorInicial = callback(valorInicial, element);
      
    }
    
    return valorInicial;
  }

  return array
}
