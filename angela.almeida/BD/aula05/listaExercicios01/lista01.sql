--Exercicio 01:
SELECT * FROM (SELECT SUBSTR(NOME,1,(INSTR(NOME,' ')-1)) INICIALNOME, COUNT(1) CONTAGEM 
FROM
    CLIENTE
GROUP BY SUBSTR(NOME,1,(INSTR(NOME,' ')-1))
ORDER BY CONTAGEM DESC)
WHERE ROWNUM = 1

--Exercicio 02:
SELECT COUNT(1), SUM(VALORPEDIDO) FROM PEDIDO WHERE TO_CHAR(DATAPEDIDO, 'MM-YY') = '03-18'

--Exercicio 03:
(SELECT c.uf, count(1)quantidade FROM CIDADE c,cliente a WHERE c.idcidade = a.idcidade group by c.uf order by quantidade asc fetch first 1 row only) 
UNION all (SELECT c.uf, count(1)quantidade 
FROM CIDADE c,cliente a 
WHERE c.idcidade = a.idcidade group by c.uf order by quantidade desc fetch first 1 row only)


--Exercicio 04: 
INSERT INTO produto (idproduto,nome,datacadastro,precocusto,precovenda,situacao)
 VALUES ((SELECT MAX(IDPRODUTO) +1 FROM PRODUTO),'COTURNO PICA-PAU',sysdate,77.95,77.95,'A')
 
 
--Exercicio 05: 

--01 forma:
SELECT * FROM PRODUTO WHERE IDPRODUTO NOT IN(SELECT IDPRODUTO FROM PEDIDOITEM)
--02 forma: 
SELECT prod.* FROM PRODUTO prod 
LEFT JOIN PEDIDOITEM ped_item ON prod.IDPRODUTO = ped_item.IDPRODUTO
WHERE ped_item.IDPRODUTO IS NULL

--Exercicio 06: 
SELECT prod.NOME, SUM(prod.PRECOVENDA * ped_item.QUANTIDADE) AS LUCRO FROM PRODUTO prod 
JOIN PEDIDOITEM ped_item ON prod.IDPRODUTO = ped_item.IDPRODUTO
JOIN PEDIDO ped ON ped_item.IDPEDIDO = ped.IDPEDIDO
WHERE TO_CHAR(DATAPEDIDO, 'YYYY') = '2018' 
GROUP BY prod.NOME
ORDER BY LUCRO DESC
FETCH NEXT 30 ROWS ONLY



