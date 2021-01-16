--Exercicio 01:

DECLARE

CURSOR C_LISTACLIENTE IS Select cl.nome ,cl.IDCIDADE from Cliente Cl;
vCidade CIDADE.NOME%TYPE;
CURSOR C_ListaCidade (cNomeCidade Cidade.nome%TYPE) IS
Select c.nome, c.uf from cidade c where c.nome = cNomeCidade group by c.nome, c.uf  having count(1) > 1;
BEGIN
FOR clien IN C_LISTACLIENTE LOOP
SELECT d.nome into vCidade FROM CIDADE d WHERE d.idcidade = clien.idcidade;
FOR reg IN C_ListaCidade(vCidade) LOOP
DBMS_OUTPUT.PUT_LINE(clien.nome);
END LOOP;
end loop;
END;

--Exercicio 02:

--Exercicio 02:
DECLARE
    CURSOR C_PEDIDO(ID IN NUMBER) IS
        SELECT QUANTIDADE, PRECOUNITARIO FROM PEDIDOITEM
        WHERE IDPEDIDO = ID;
    vPedidoId PEDIDO.IDPEDIDO%TYPE;
    vValor PEDIDO.VALORPEDIDO%TYPE;
BEGIN
    vPedidoId := 7;
    vValor := 0.0;
    FOR i IN C_PEDIDO(vPedidoId) LOOP
        vValor := vValor + (i.QUANTIDADE * i.PRECOUNITARIO);
    END LOOP;
    UPDATE PEDIDO
    SET VALORPEDIDO = vValor
    WHERE IDPEDIDO = vPedidoId;
END;

--Exercicio 03:
DECLARE
    CURSOR C_Clientes IS
    SELECT c.IDCLIENTE FROM CLIENTE c JOIN PEDIDO p ON c.IDCLIENTE = p.IDCLIENTE
    WHERE IDPEDIDO NOT IN
    (
        SELECT IDPEDIDO FROM PEDIDOITEM WHERE p.DATAPEDIDO >= ADD_MONTHS(TRUNC(SYSDATE), - 6)
    );
    BEGIN
    FOR i IN C_Clientes LOOP
        UPDATE CLIENTE SET SITUACAO = 'I'
        WHERE IDCLIENTE = i.IDCLIENTE;
    END LOOP;
END;

--Exercicio 04:
DECLARE
    CURSOR C_ListaProdutos(Id IN NUMBER, Mes IN NUMBER, Ano IN NUMBER) IS
        SELECT p.IdProduto AS IdProduto, SUM(pi.Quantidade) Quantidade_Produto FROM Produto p
        JOIN PedidoItem pi ON p.IdProduto = pi.IdProduto AND p.IdProduto = Id
        JOIN Pedido ped ON ped.IDPEDIDO = pi.IDPEDIDO 
        WHERE TO_CHAR(ped.DATAPEDIDO, 'MM') = Mes AND TO_CHAR(ped.DATAPEDIDO, 'YYYY') = Ano
        GROUP BY p.IdProduto;
    CURSOR C_MateriaisProduto(IdProduto IN NUMBER) IS
        SELECT m.IdMaterial, m.Descricao, pm.Quantidade FROM Material m
        JOIN ProdutoMaterial pm ON m.IdMaterial = pm.IdMaterial AND pm.IdProduto = IdProduto;
BEGIN
    FOR reg IN C_ListaProdutos(2, 2, 2014) LOOP
        FOR item IN C_MateriaisProduto(reg.IdProduto) LOOP
            DBMS_OUTPUT.PUT_LINE(item.Descricao || ' -> ' || item.Quantidade * reg.Quantidade_Produto);
        END LOOP;
    END LOOP;
END;