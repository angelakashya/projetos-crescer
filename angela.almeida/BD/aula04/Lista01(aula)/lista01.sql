--Exercicio 01: 
SELECT TO_CHAR(SYSDATE, 'DD/MM/YYYY HH:MI:SS') AS DATA FROM DUAL 

--Exercicio 02:
SELECT LOWER(SUBSTR(NOMEEMPREGADO,1,4)) FROM EMPREGADO

--Exercicio 03: 
SELECT CONCAT(NOMEEMPREGADO, CONCAT(' - ', CARGO)) AS NOMECARGO1 FROM EMPREGADO

--Exercicio 04: 
SELECT concat(DATAADMISSAO, ' 08:00:00') AS ADMISSAO FROM EMPREGADO