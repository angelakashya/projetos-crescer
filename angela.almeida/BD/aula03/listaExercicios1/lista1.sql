--Exercicio 01:
SELECT
    IDEMPREGADO,
    NOMEEMPREGADO
FROM 
    EMPREGADO
ORDER BY
    DATAADMISSAO 
	
--Exercicio 02:

SELECT 
    NOMEEMPREGADO
    SALARIO
FROM
    EMPREGADO
WHERE
    COMISSAO != 0

--Exercicio 03:
 SELECT
    IDEMPREGADO,
    NOMEEMPREGADO AS NOME,
    (SALARIO * 13) AS SALARIOANUAL,
    (COMISSAO * 12) AS COMISSAOANUAL,
    ((SALARIO * 13)+ (COMISSAO * 12)) AS RENDAANUAL
FROM 
    EMPREGADO;
	
---Exercicio 04: 
SELECT
    IDEMPREGADO,
    NOMEEMPREGADO,
    CARGO,
    (SALARIO*13) AS SALARIOANUAL
FROM
    EMPREGADO 
WHERE
(SALARIO*13) > 18500
ORDER BY
    IDEMPREGADO
	
---Exercicio 05: 
SELECT 
    NOMEEMPREGADO,
    CARGO
FROM
    EMPREGADO
WHERE
    CARGO = 'ATENDENTE' OR IDGERENTE = 7698
ORDER BY 
    NOMEEMPREGADO

---Exercicio 06:
	SELECT 
    IDDEPARTAMENTO,
    NOMEDEPARTAMENTO
FROM
    DEPARTAMENTO
WHERE
    LOCALIZACAO LIKE 'SAO%'
ORDER BY
    NOMEDEPARTAMENTO
	
---EXERCICIO 07:
SELECT * FROM CIDADE
WHERE 
    IDCIDADE BETWEEN 4 AND 9 
ORDER BY
    IDCIDADE
	
--EXERCICIO 08:
SELECT * FROM DEPARTAMENTO WHERE NOT EXISTS 
(
    SELECT * FROM EMPREGADO
    WHERE
        DEPARTAMENTO.IDDEPARTAMENTO = EMPREGADO.IDDEPARTAMENTO
)
ORDER BY
    IDDEPARTAMENTO	

--EXERCICIO 09:
SELECT 
    NOMEEMPREGADO,
    CARGO
FROM
    EMPREGADO
WHERE
    IDDEPARTAMENTO IS NUll
ORDER BY
    NOMEEMPREGADO

--EXERCICIO 10:
SELECT 
    NOMEEMPREGADO
FROM 
    EMPREGADO
WHERE
    IDGERENTE IN(7566, 7698, 7782)
ORDER BY
    NOMEEMPREGADO