import org.junit.Test;

public class ExemploTest {
    @Test
    public void exemplo() {
        System.out.println(0000001);
    }

    @Test
    public void exemploCopiaEReferencia() {
        //Copia durante a atribuicao existe somente em tipo primitiva
        int a = 2;
        int b = a;
        System.out.println(a);
        System.out.println(b);

        a = 3;
        System.out.println(a);
        System.out.println(b);

        //Durante a atribuicao de objetos, ocorre uma atribuicao de referencia
        Conta conta = new Conta("1234", "a22", "03541462458");
        conta.depositar(1000);
        conta.setNumero("1234");
        conta.setAgencia("a22");

        Conta conta2 = conta;

        System.out.println("Conta | numero: " + conta.getNumero() + ", agencia: " + conta.getAgencia() + ", saldo: " + conta.getSaldo());
        System.out.println("Conta2 | numero: " + conta2.getNumero() + ", agencia: " + conta2.getAgencia() + ", saldo: " + conta2.getSaldo());

        conta2.depositar(2000);
        System.out.println("Conta | numero: " + conta.getNumero() + ", agencia: " + conta.getAgencia() + ", saldo: " + conta.getSaldo());
        System.out.println("Conta2 | numero: " + conta2.getNumero() + ", agencia: " + conta2.getAgencia() + ", saldo: " + conta2.getSaldo());
    }


}
