/* criar um package constituido de 2 procedures e 1 function com as seguintes funções:

1) Reajusta o valor de venda dos produtos (apenas preço venda) de acordo com uma porcentagem definida
por parâmetro para produtos com a situação Ativo, ignore os pedidos já feitos com o preço antigo
2) Calcula e printa o valor total adquirido com o reajuste (valor antigo de preço de venda e novo valor, 
mostrando também a diferença entre os valores)
3) Ranking dos 3 produtos mais caros depois do reajuste
*/

create or replace PACKAGE pck_reajuste AS
  
  FUNCTION ajusta_valor_produto(pPorcentagem in NUMBER) RETURN NUMBER;
  
  PROCEDURE printa_valores(pValorAnterior in NUMBER);
  
  PROCEDURE reajusta_produtos(pPorcentagem in NUMBER);
                                        
END;

/

create or replace PACKAGE BODY pck_reajuste AS

  /* Calcula o novo valor para os produtos baseado na porcentagem 
     Calcula a soma dos valores antigos como retorno
  */
  FUNCTION ajusta_valor_produto(pPorcentagem in NUMBER) RETURN NUMBER AS rSoma produto.precovenda%type;
    
  BEGIN
    SELECT SUM(PRECOVENDA)
    INTO rSoma
    FROM PRODUTO
    WHERE SITUACAO = 'A'

    UPDATE PRODUTO
    SET PRECOVENDA  = PRECOVENDA + (PRECOVENDA *(pPorcentagem /100))
    WHERE SITUACAO = 'A'
    
     null;
     RETURN rSoma;

  END ajusta_valor_produto;

  /* Calcula a diferença entre os valores antigo e novo 
     Calcula a soma dos valores novos
     Printa os resultados em forma de relatório
  */
  PROCEDURE printa_valores(pValorAnterior IN NUMBER) AS

  somaAtual produto.precovenda%type;
  diferencaSomas produto.precovenda%type;

  BEGIN
    SELECT SUM(PRECOVENDA - pValorAnterior)
    FROM PRODUTO
    WHERE SITUACAO = 'A'
    
    SELECT SUM(PRECOVENDA)
    FROM PRODUTO
    WHERE SITUACAO = 'A'
    
     diferencasomas := 0;

     DBMS_OUTPUT.PUT_LINE('Somatório antigo: ' || pvaloranterior || ', novo somatório: ' || somaatual || ', diferença de: ' || diferencasomas);

  END printa_valores;

 /* Realiza o levantamento do ranking após chamar os outros procedimentos */
  PROCEDURE reajusta_produtos(pPorcentagem in NUMBER) AS

  rsoma produto.precovenda%type;

  CURSOR produtos_mais_caros IS
        Select 'Nome' nome, 'precovenda' precovenda from dual;

  BEGIN 

    rsoma := 0;
    printa_valores(pValorAnterior=> rsoma);

     FOR produto IN produtos_mais_caros LOOP
        DBMS_OUTPUT.PUT_LINE('Produto: ' || produto.nome || ', valor: '|| produto.precovenda);
     END LOOP;

  END reajusta_produtos;

END pck_reajuste;
/

exec pck_reajuste.reajusta_produtos(5);