import org.junit.Test;

public class ExemploOO {
    @Test
    public void exemploPessoa() {
        Pessoa angela = new Pessoa();
        angela.apresentarse();

        Conta contaAngela = new Conta();
        contaAngela.deposito(1000);
    }


}
