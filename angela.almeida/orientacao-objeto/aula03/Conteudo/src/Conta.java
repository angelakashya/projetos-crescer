public class Conta {
    private String numero;
    private String agencia;
    private String senha;
    private String cpfTitular;
    private double saldo;
    private final double LIMITE_PADRAO = 100; //constante
    public static final String TIPO_CONTA = "Conta Corrente"; //atributo de classe constante
    public static int QUANTIDADE_CONTAS_CRIADAS; //atributo de classe variavel

    public Conta(String numero, String agencia, String cpfTitular){
        this.numero = numero;
        this.agencia = agencia;
        this.cpfTitular = cpfTitular;
        QUANTIDADE_CONTAS_CRIADAS++;
    }

    public Conta(String numero, String agencia, String cpfTitular, double saldo){
        this.numero = numero;
        this.agencia = agencia;
        this.cpfTitular = cpfTitular;
        this.saldo = saldo;
        QUANTIDADE_CONTAS_CRIADAS++;
    }
    public boolean sacar(double valorASacar) {
        if (saldo + LIMITE_PADRAO >= valorASacar) {
            saldo = saldo - valorASacar;
            return true;
        }
        return false;
    }

    public void depositar(double valorADepositar) {
        saldo = saldo + valorADepositar;
    }

    public void transferir(Conta contaDestino, double valorATransferir) {
        boolean foiPossivelSacar = this.sacar(valorATransferir);

        if(foiPossivelSacar) {
            contaDestino.depositar(valorATransferir);
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }


}
