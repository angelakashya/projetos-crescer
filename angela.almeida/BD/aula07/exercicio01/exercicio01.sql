CREATE OR REPLACE PROCEDURE lereatualizar AS
    CURSOR retornaid IS
    SELECT
        p.idproduto
    FROM
        produto p;

BEGIN
    FOR i IN retornaid LOOP
        IF ( buscarsituacao(i.idproduto) = 'A' ) THEN
            UPDATE produto
            SET
                precovenda = precovenda + ( precovenda *0.05 )
            WHERE
                i.idproduto = idproduto;

        END IF;
    END LOOP;
END;

CREATE OR REPLACE FUNCTION buscarsituacao (
    idprod IN NUMBER
) RETURN VARCHAR2 AS
    vsituacao produto.situacao%type;
BEGIN
    SELECT
        p.situacao
    INTO vsituacao
    FROM
        produto p
    WHERE
        p.idproduto = idprod;

    RETURN vsituacao;
END;