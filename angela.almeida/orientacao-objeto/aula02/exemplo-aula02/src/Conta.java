public class Conta {
    int numeroConta;
    double saldo;
    String agencia;

    public void deposito( double valor) {
        System.out.println("Depositando: " + valor);
    }
}
