package HabilidadesEspeciais;

public class HabilidadeEspecial {
    private static final double MAGIA = 0.12;
    private static final double SUPERFORCA = 0.10;
    private static final double SUPERVELOCIDADE = 0.08;
    private static final double SEMTALENTO = 0;
    private double percentualBonus;

    public HabilidadeEspecial(double percentualBonus) {
        this.percentualBonus = percentualBonus;
    }

    public double getPercentualBonus() {
        return percentualBonus;
    }
}
