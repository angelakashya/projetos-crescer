create table LogProduto (
    idLogProduto NUMBER GENERATED ALWAYS AS IDENTITY,
    usuario VARCHAR2(25),
    dataModificacao DATE DEFAULT sysdate,
    idProdutoAlterado NUMBER NOT NULL,
    operacao CHAR(1) NOT NULL,
    CONSTRAINT Pk_IdLogProduto PRIMARY KEY (idLogProduto)
);

CREATE OR REPLACE TRIGGER tr_aud_oper_produto
    AFTER INSERT OR UPDATE OR DELETE ON produto
    FOR EACH ROW
DECLARE
  v_operacao CHAR(1);
      v_idProdutoAlterado NUMBER;


BEGIN

  IF INSERTING THEN
     v_operacao := 'I';
     v_idProdutoAlterado := :new.idProduto;
  ELSIF UPDATING THEN
     v_operacao := 'U';
     v_idProdutoAlterado := :new.idProduto;
  ELSE
     v_operacao := 'D';
     v_idProdutoAlterado := :old.idProduto;
  END IF;

  INSERT INTO LogProduto (usuarioModificao, dataModificacao, idProduto, operacao)
      VALUES (user, sysdate, v_idProdutoAlterado, v_operacao);

End tr_aud_oper_produto;