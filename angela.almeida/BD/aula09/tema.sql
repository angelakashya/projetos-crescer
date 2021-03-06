--Exercicio 01:
CREATE TABLE PEDIDO_BKP (
    IDPEDIDO NUMBER (38,0),
    IDCLIENTE NUMBER(38,0),
    DATAPEDIDO DATE,
    DATAENTREGA DATE,
    VALORPEDIDO NUMBER (12,2),
    SITUACAO CHAR(1),
    CONSTRAINT PK_PEDIDOBKP PRIMARY KEY(IDPEDIDO)
);

CREATE TABLE PEDIDOITEM_BKP (
    IDPEDIDOITEM NUMBER (38,0),
    IDPEDIDO NUMBER (38,0),
    QUANTIDADE NUMBER(12,3),
    PRECOUNITARIO NUMBER(12,2),
    SITUACAO CHAR(1),
    IDPRODUTO NUMBER(38,0),
    CONSTRAINT PK_PEDIDOITEMBKP PRIMARY KEY(IDPEDIDOITEM)
);

--Exercicio 02:
SELECT * FROM (SELECT cid.UF COUNT(*) AS QUANTIDADE_VENDAS
    FROM PEDIDO ped
    INNER JOIN CLIENTE cli ON cli.IDCLIENTE = ped.IDCLIENTE
    INNER JOIN CIDADE cid ON cid.IDCIDADE = cli.IDCIDADE
    GROUP BY cid.UF
    ORDER BY cid.UF
    WHERE TO_CHAR(ped.DATAPEDIDO, 'YYYY') = '2018' 
    );
	
--Exercicio 03:
SELECT * FROM (SELECT prod.IDPRODUTO AS PRODUTOS_JANEIRO
    FROM PRODUTO prod 
    INNER JOIN PEDIDOITEM item ON prod.IDPRODUTO  = item.IDPRODUTO
    INNER JOIN PEDIDO ped ON item.IDPEDIDO = ped.IDPEDIDO
    WHERE (TO_CHAR(ped.DATAEDIDO, 'YYYY') = '2019') AND (SITUACAO = 'C') OR (SITUACAO = 'I' 
	);
	
--Exercicio 04:
	SELECT * (SELECT prod.IDPRODUTO, prod.NOME AS PRODUTOS_JANEIRO
    FROM PRODUTO prod 
    INNER JOIN PEDIDOITEM item ON prod.IDPRODUTO  = item.IDPRODUTO
    INNER JOIN PEDIDO ped ON item.IDPEDIDO = ped.IDPEDIDO
    WHERE (TO_CHAR(ped.DATAEDIDO, 'YYYY') = '2019') AND (SITUACAO = 'C') OR (SITUACAO = 'I' 
	);
	
--Exercicio 05:
SELECT emp.NOMEEMPREGADO, gerente.NOMEEMPREGADO AS GERENTE, dep.* FROM EMPREGADO emp 
JOIN DEPARTAMENTO dep ON emp.IDDEPARTAMENTO = dep.IDDEPARTAMENTO
JOIN EMPREGADO gerente ON emp.IDGERENTE = gerente.IDEMPREGADO

--Exercicio 06:
SELECT prod.NOME, mat.IDMATERIAL, mat.DESCRICAO, ped.IDPEDIDO FROM PRODUTO prod
JOIN PRODUTOMATERIAL prodmat ON prod.IDPRODUTO = prodmat.IDPRODUTO
JOIN MATERIAL mat ON prodmat.IDMATERIAL = mat.IDMATERIAL
JOIN PEDIDOITEM item ON prod.IDPRODUTO = item.IDPRODUTO
JOIN PEDIDO ped ON item.IDPEDIDO = ped.IDPEDIDO
WHERE prod.IDPRODUTO = 320 AND ped.IDPEDIDO = 39969

--Exercicio 07:
FUNCTION busca_razaosocial_cliente(pIdCliente IN NUMBER) RETURN VARCHAR AS rRazaoSocial CLIENTE.RAZAOSOCIAL%TYPE;

BEGIN
    SELECT RAZAOSOCIAL 
    INTO rRazaoSocial
    FROM CLIENTE
    WHERE IDCLIENTE = pIdCliente;
        
        null;
        RETURN rRazaoSocial;
END busca_razaosocial_cliente;

--Exercicio 08:

FUNCTION precototal_itempedido(pIdPedido IN NUMBER) RETURN NUMBER AS rValorTotal NUMBER;

BEGIN
    SELECT SUM(PRECOUNITARIO)
    INTO rValorTotal
    FROM PEDIDOITEM
    WHERE IDPEDIDO = pIdPedido;
    
    RETURN rValorTotal;
END precototal_itempedido;
/

UPDATE PEDIDO
SET VALORPEDIDO = pck_aula09.precototal_itempedido(IDPEDIDO)

--Exercicio 09:

CREATE OR REPLACE TRIGGER TR_SQ_ATUALIZAR_VALOR
    AFTER UPDATE OR DELETE ON PEDIDOITEM
    FOR EACH ROW
    BEGIN
        UPDATE PEDIDO
        SET VALORPEDIDO = pck_aula09.precototal_itempedido(IDPEDIDO)
        WHERE IDPEDIDO = :NEW.IDPEDIDO;
        
    END TR_SQ_ATUALIZAR_VALOR;



	
	
	
	