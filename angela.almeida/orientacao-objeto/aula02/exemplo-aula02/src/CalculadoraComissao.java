public class CalculadoraComissao {

    public double calcularComissao(double valorVendidoMes, double porcentagemComissao) {
        double comissao = valorVendidoMes * (porcentagemComissao / 100);

        return comissao;
    }
}
