--Exercicio 01 

A - Certo 
B - Errado, não pode separar com virgula
C - Certo
D - Errado, valor não é boolean 


--Exercicio 02: 

DECLARE
    vIDPedido Pedido.idpedido%TYPE;
    vDataEntrega Pedido.dataentrega%TYPE;
    vValorPedido Pedido.valorpedido%TYPE;
BEGIN
   vIDPedido:= 19549;
   
    Select  p.dataentrega, p.valorpedido
    into vDataEntrega, vValorPedido
    from pedido p
    where idpedido = vIDPedido;
    
    if vDataEntrega > sysdate and vValorPedido > 9000 then
        update pedido set valorpedido = valorpedido + valorpedido - 0.05
        where idpedido = vIDPedido;
    end if;
END;
