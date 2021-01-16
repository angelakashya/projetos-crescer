import org.junit.Assert;
import org.junit.Test;

public class ContaTest {

    @Test
    public void deveAtualizarSaldoQuandoOcorrerUmSaque() {
        //arrange
        Conta contaPablo = new Conta("1234", "a22", "03541462458", 1000);
        contaPablo.depositar(1000);
        double saldoEsperado = 1400;
        double valorASacar = 600;

        //act
        contaPablo.sacar(valorASacar);

        //assert
        Assert.assertEquals(saldoEsperado, contaPablo.getSaldo(), 0.01);
    }

    @Test
    public void deveManterOSaldoQuandoOSaqueNaoOcorrerPorSaldoInsuficiente() {
        //arrange
        Conta contaPablo = new Conta("1234", "a22", "03541462458");
        contaPablo.depositar(100);
        double saldoEsperado = 100;
        double valorASacar = 600;

        //act
        contaPablo.sacar(valorASacar);

        //assert
        Assert.assertEquals(saldoEsperado, contaPablo.getSaldo(), 0.01);
    }

    @Test
    public void deveRecusarSaqueQuandoAContaNaoPossuiSaldoInsuficiente() {
        //arrange
        Conta contaPablo = new Conta("1234", "a22", "03541462458");
        contaPablo.depositar(100);
        double valorASacar = 600;

        //act
        boolean foiPossivelSacar = contaPablo.sacar(valorASacar);

        //assert
        Assert.assertFalse(foiPossivelSacar);
    }


    @Test
    public void deveAtualizarSaldoQuandoOcorrerUmDepositoDeValorRedondo() {
        //arrange
        Conta contaPablo = new Conta("1234", "a22", "03541462458");
        contaPablo.depositar(500);
        double saldoEsperado = 800;

        //act
        contaPablo.depositar(300);

        //assert
        Assert.assertEquals(saldoEsperado, contaPablo.getSaldo(), 0.01);
    }

    @Test
    public void deveAtualizarSaldoQuandoOcorrerUmDepositoDeValorComPontoFlutuante() {
        //arrange
        Conta contaPablo = new Conta("1234", "a22", "03541462458");
        contaPablo.depositar(500);
        double saldoEsperado = 800;

        //act
        contaPablo.depositar(300);

        //assert
        Assert.assertEquals(saldoEsperado, contaPablo.getSaldo(), 0.01);
    }

    @Test
    public void deveAtualizarSaldoQuandoRealizarUmaTransferenciaParaOutraConta(){
        //arrange
        Conta contaOrigem = new Conta("1234", "a22", "03541462458");
        contaOrigem.depositar(500);

        Conta contaDestino = new Conta("12345", "a22", "04023695871");

        double saldoEsperadoNaContaOrigemAposTransferencia = 300;

        //act
        contaOrigem.transferir(contaDestino, 200);

        //assert
        Assert.assertEquals(saldoEsperadoNaContaOrigemAposTransferencia, contaOrigem.getSaldo(), 0.01);
    }

    @Test
    public void deveManterOSaldoQuandoNaoTrasferirPorFaltaDeLimite() {
        //arrange
        Conta contaOrigem = new Conta("1234", "a22", "03541462458");
        contaOrigem.depositar(500);

        Conta contaDestino = new Conta("12345", "a22", "04023695871");

        double saldoEsperadoNaContaOrigemAposTransferencia = 500;

        //act
        contaOrigem.transferir(contaDestino, 1000);

        //assert
        Assert.assertEquals(saldoEsperadoNaContaOrigemAposTransferencia, contaOrigem.getSaldo(), 0.01);
    }

    @Test
    public void deveManterOSaldoNaContaDestinoQuandoAContaOrigemNaoTrasferirPorFaltaDeLimite() {
        //arrange
        Conta contaOrigem = new Conta("1234", "a22", "03541462458");
        contaOrigem.depositar(500);

        Conta contaDestino = new Conta("12345", "a22", "04023695871");

        double saldoEsperadoNaContaDestinoAposTransferencia = 0;

        //act
        contaOrigem.transferir(contaDestino, 1000);

        //assert
        Assert.assertEquals(saldoEsperadoNaContaDestinoAposTransferencia, contaDestino.getSaldo(), 0.01);
    }

    @Test
    public void deveSerContaCorrente() {
        System.out.println(Conta.TIPO_CONTA);
    }

    @Test
    public void deveAtualizarContadorContasQuandoCriarObjetos() {
        Conta c1 = new Conta("12345", "a22", "04023695871");
        Conta c2 = new Conta("12345", "a22", "04023695871");
        int quantidadeContasEsperadas = 2;
        Assert.assertEquals(quantidadeContasEsperadas, Conta.QUANTIDADE_CONTAS_CRIADAS);
    }

}
