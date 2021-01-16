--Exercicio 01:
--Criado função, passado como parametro as duas Strings a serem concatenadas, e passando o retorno e o tipo de retorno. Feito um select com uma função concat que irá concatenar as duas Strings.
--Usando o INTO para adicionar a string concatenada dentro da variaval de retorno vNome e retonando ela ao final da função.
FUNCTION fnc_concateta_string(pNome1 in STRING, pNome2 in STRING) RETURN STRING AS rNome STRING;
BEGIN 
    SELECT CONCAT(pNome1, pNome2)
    INTO rNome
    FROM DUAL;
    
    RETURN rNome;
END fnc_concateta_string;


--Exercicio 02 
CREATE OR REPLACE PACKAGE pck_licitacao AS
--Declarações das funções usadas no body
    FUNCTION fnc_get_empresas (
        p_list_ids_empresas IN VARCHAR2
    ) RETURN empresastable;

    FUNCTION formata_cnpj (
        p_cnpj IN VARCHAR2
    ) RETURN VARCHAR2;

    FUNCTION fnc_get_pos_perc_fat_geral (
        par_idempresa NUMBER
    ) RETURN NUMBER;

    FUNCTION fnc_get_pos_qtd_rank_fat (
        par_idempresa NUMBER
    ) RETURN NUMBER;
--Declaração da procedure usada no body
    PROCEDURE prc_get_empresa (
        p_cnpj                         IN OUT  VARCHAR2,
        p_nome_empresa                 OUT     VARCHAR2,
        p_nome_cidade                  OUT     VARCHAR2,
        p_faturamento_anual            OUT     VARCHAR2,
        p_situacao                     OUT     VARCHAR2,
        p_pos_perc_geral_faturamento   OUT     NUMBER,
        p_pos_qtd_rank_fat_emp         OUT     NUMBER
    );

END pck_licitacao;

CREATE OR REPLACE PACKAGE BODY pck_licitacao AS
--Exercicio 3 
    FUNCTION fnc_get_empresas (
        p_list_ids_empresas IN VARCHAR2
    ) RETURN empresastable AS
--Cria a variavel de retorno da tabela
        retorno empresastable;
--Cria o cursor que splita a string e coloca em forma de tabela usando regex
        CURSOR idempresas IS
        SELECT
            TRIM(regexp_substr(str, '[^:]+', 1, level)) str
        FROM
            (
                SELECT
                    p_list_ids_empresas str
    FROM
                    dual
            )
        CONNECT BY
            instr(str, ':', 1, level - 1) > 0;
--Cria o cursor de empresas para fazer a comparação e colocar o nome
        CURSOR cr_empresas IS
        SELECT
            nome,
            idempresa
        FROM
            lic_empresa;
    BEGIN
 -- Chame o construtor para criar a variável retornada
        retorno := empresastable();
--Adicione um registro após o outro à tabela retornada.
        FOR emp in idempresas LOOP FOR e IN cr_empresas LOOP
            IF ( e.idempresa = emp.str ) THEN
                retorno.extend;
                retorno(retorno.count) := empresas(e.nome);
            END IF;
        END LOOP;
        END LOOP;
 -- retorna os registros salvos em forma de tabela:
        RETURN retorno;
    END fnc_get_empresas;


--Criei uma function para formatar o cnpj de acordo com o inserido por parametro, 
--tratei 4 tipos diferentes usando regex (obs: nao sei explicar o regex, peguei ele pronto, somente fiz alterações pequenas para adequar)

    FUNCTION formata_cnpj (
        p_cnpj IN VARCHAR2
    ) RETURN VARCHAR2 IS
    BEGIN
        IF ( length(p_cnpj) = 14 ) THEN
            RETURN regexp_replace(lpad(p_cnpj, 14), '([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})', '\1.\2.\3/\4-');
        ELSIF ( length(p_cnpj) = 13 ) THEN
            RETURN regexp_replace(lpad('0' || p_cnpj, 14), '([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})', '\1.\2.\3/\4-');
        ELSIF ( length(p_cnpj) = 17 ) THEN
            RETURN '0' || p_cnpj;
        ELSIF ( length(p_cnpj) = 18 ) THEN
            RETURN p_cnpj;
        ELSE
            RETURN 'Cnpj não inserido corretamente';
        END IF;
    END;

--Função que atende a necessidade de retornar a porcentagem do faturamento da empresa de acordo com o faturamento total obtido pela soma de todos
    FUNCTION fnc_get_pos_perc_fat_geral (
        par_idempresa NUMBER
    ) RETURN NUMBER IS
        vfaturamentototal   NUMBER;
        vpercentual         NUMBER;
    BEGIN
        SELECT
            SUM(faturamento_anual)
        INTO vfaturamentototal
        FROM
            lic_empresa
        WHERE
            situacao = 'S';

        SELECT
            round((faturamento_anual * 100) / vfaturamentototal, 3)
        INTO vpercentual
        FROM
            lic_empresa
        WHERE
            situacao = 'S'
            AND idempresa = par_idempresa;

        RETURN vpercentual;
    END;


--Funçao que atende a necessidade de retornar o rank da empresa de acordo com a porcentagem de faturamento
    FUNCTION fnc_get_pos_qtd_rank_fat (
        par_idempresa NUMBER
    ) RETURN NUMBER IS
        vfaturamentototal   NUMBER;
        vranking            NUMBER;
    BEGIN
        SELECT
            SUM(faturamento_anual)
        INTO vfaturamentototal
        FROM
            lic_empresa
        WHERE
            situacao = 'S';

        SELECT
            ranking
        INTO vranking
        FROM
            (
                SELECT
                    idempresa,
                    coalesce(fnc_get_pos_perc_fat_geral(idempresa), 0) AS porc,
                    RANK() OVER(
                        ORDER BY
                            coalesce(fnc_get_pos_perc_fat_geral(idempresa), 0) DESC
                    ) ranking
                FROM
                    lic_empresa
                ORDER BY
                    porc DESC
            )
        WHERE
            idempresa = par_idempresa;

        RETURN vranking;
    END;
--Procedure que recebe os parametros para busca e retornando os parametros out
    PROCEDURE prc_get_empresa (
        p_cnpj                         IN OUT  VARCHAR2,
        p_nome_empresa                 OUT     VARCHAR2,
        p_nome_cidade                  OUT     VARCHAR2,
        p_faturamento_anual            OUT     VARCHAR2,
        p_situacao                     OUT     VARCHAR2,
        p_pos_perc_geral_faturamento   OUT     NUMBER,
        p_pos_qtd_rank_fat_emp         OUT     NUMBER
    ) IS
--Cursor que pega a empresa de acordo com o cnpj
        vidempresa NUMBER;
        CURSOR cr_empresa IS
        SELECT
            *
        FROM
            lic_empresa
        WHERE
            cnpj = formata_cnpj(p_cnpj);
            
--Cursor que pega as cidades
        CURSOR cr_cidade IS
        SELECT
            nome,
            uf
        FROM
            lic_cidade
        WHERE
            idcidade = (
                SELECT
                    idcidade
                FROM
                    lic_empresa
                WHERE
                    cnpj = formata_cnpj(p_cnpj)
            );

    BEGIN
--select pra salvar o idempresa para consultar nas funções acima
        SELECT
            idempresa
        INTO vidempresa
        FROM
            lic_empresa
        WHERE
            cnpj = formata_cnpj(p_cnpj);

        p_cnpj := formata_cnpj(p_cnpj);
        
--loop para conseguir colocar os dados nas variaveis out
        FOR emp IN cr_empresa LOOP
            p_nome_empresa := emp.nome;
            p_faturamento_anual := TO_CHAR(emp.faturamento_anual, 'FM999G999G990D00');
            p_situacao :=
                CASE emp.situacao
                    WHEN 'S' THEN
                        'Ativo'
                    ELSE 'Inativo'
                END;
        END LOOP;
--loop para conseguir colocar os dados nas variaveis out
        FOR cid IN cr_cidade LOOP 
            p_nome_cidade := cid.nome || ' - ' || cid.uf;
        END LOOP;
        
--chamada das funções acima para retorno nas variaveis out
        p_pos_qtd_rank_fat_emp := fnc_get_pos_qtd_rank_fat(vidempresa);
        p_pos_perc_geral_faturamento := fnc_get_pos_perc_fat_geral(vidempresa);
    END;

END pck_licitacao;



--Exercicio 04:

--Criando uma procedure e passando dentro dela os parametros a serem utilizados
--Fazendo um IF para verificar se a variavel p_dml nao esta de acordo com os parametros exigidos, e caso ela nao esteja, o log é alterado para 'codigo dml invaalido
--Passando as outras condições que trabalham conforme o estado da dml e alterando o log conforme a ação realizada
--Passando uma execption para tratar o possivel erro.

CREATE OR REPLACE PROCEDURE prc_dml_empresas(   p_dml IN varchar2,
                                                p_idempresa IN OUT NUMBER,
                                                p_nome IN OUT varchar2,
                                                p_idcidade IN OUT NUMBER,
                                                p_cnpj IN OUT varchar2,
                                                p_faturamento_anual IN OUT NUMBER,
                                                p_data_abertura IN OUT DATE,
                                                p_situacao IN OUT varchar2,
                                                p_cpf IN OUT varchar2,
                                                p_tipo_pessoa IN OUT varchar2,
                                                p_log IN OUT varchar2) IS

BEGIN

IF UPPER(p_dml) NOT IN ('D', 'I', 'U') THEN
    p_log := 'Codigo dml invalido';
ELSIF (UPPER(p_dml) = 'D') THEN
    DELETE FROM lic_empresa
    WHERE idempresa = p_idempresa;
    p_nome := null; p_idcidade := null;
    p_cnpj := null; p_faturamento_anual := null;
    p_data_abertura := null; p_situacao := null; 
    p_cpf := null; p_tipo_pessoa := null;
    p_log := 'Registro deletado com sucesso';
ELSIF (UPPER(p_dml) = 'I') THEN
    INSERT INTO lic_empresa (idempresa, nome, idcidade, cnpj, faturamento_anual, data_abertura, situacao, cpf, tipo_pessoa)
    VALUES (p_idempresa, p_nome, p_idcidade, p_cnpj, nvl(p_faturamento_anual, 0), nvl(p_data_abertura,SYSDATE), nvl(p_situacao, 'S'), p_cpf, p_tipo_pessoa);
    p_log := 'Registro inserido com sucesso';
ELSIF (UPPER(p_dml) = 'U') THEN
    UPDATE lic_empresa
    SET nome = p_nome, idcidade = p_idcidade, 
        cnpj = p_cnpj, faturamento_anual = p_faturamento_anual, 
        data_abertura = p_data_abertura, situacao = p_situacao, 
        cpf = p_cpf, tipo_pessoa = p_tipo_pessoa
    WHERE idempresa = p_idempresa;
        p_log := 'Registro atualizado com sucesso';
    END IF;   
	
    DBMS_OUTPUT.PUT_LINE(p_log);
    EXCEPTION WHEN OTHERS THEN
    p_log := 'Erro não tratado=' || SQLCODE || ' - ' || SQLERRM;
    
    DBMS_OUTPUT.PUT_LINE(p_log);
END;



--Exercicio 06:
--Criando Tabela com os Feriados
CREATE TABLE FERIADOS (
    DATA_FERIADO DATE
);

--Inserindo feriado do dia 12/10/2020 na tabela feriados.
INSERT INTO FERIADOS
(DATA_FERIADO) 
VALUES 
(TO_DATE('12/10/2020', 'dd/mm/yyyy'));

--Criando a função e passando as datas como parametro
CREATE OR REPLACE FUNCTION fnc_get_qtd_dias_next_vr(pDataAdmissao IN DATE, pDiaPagamento IN NUMBER) RETURN  NUMBER AS rDiasUteis NUMBER;
--Criando a variavel que salva o mes corretamente, para que se a data for depois do dia 20, contabilize os dias do proximo mes.
    vMesCorrigido NUMBER;
BEGIN
--Verificando e validando as datas
    IF TO_NUMBER(TO_CHAR(pDataAdmissao, 'dd')) > pDiaPagamento THEN
        vMesCorrigido := TO_NUMBER(TO_CHAR(pDataAdmissao, 'MM')) + 1;
    ELSE
        vMesCorrigido := TO_NUMBER(TO_CHAR(pDataAdmissao, 'MM'));
    END IF;
    WITH count_days AS
      (SELECT ROWNUM rnum
      FROM all_objects
      WHERE ROWNUM <= ( TO_DATE(TO_CHAR(pDataAdmissao, 'yyyy') || '-' || TO_CHAR(vMesCorrigido) || '-' || TO_CHAR(pDiaPagamento), 'yyyy-MM-dd') - pDataAdmissao - 1)
      )
    SELECT COUNT (1)
    into rDiasUteis
    FROM count_days cds
    WHERE TO_CHAR (pDataAdmissao + cds.rnum - 1, 'DY') NOT IN ('SAB', 'DOM')
    AND TO_CHAR(pDataAdmissao  + cds.rnum - 1, 'yyyy-MM-dd') NOT IN (SELECT TO_CHAR(DATA_FERIADO, 'yyyy-MM-dd') FROM FERIADOS);
    --Retornando os dias uteis contados.
    RETURN rDiasUteis;
END fnc_get_qtd_dias_next_vr;




