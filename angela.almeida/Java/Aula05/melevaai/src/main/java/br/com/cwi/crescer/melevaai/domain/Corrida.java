package br.com.cwi.crescer.melevaai.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class Corrida {
    private int idCorrida;
    private Veiculo veiculo;
    private Ponto pontoInicial;
    private Ponto pontoFinal;
    private Passageiro passageiro;
    private int qtdPassageiros;
    private double precoCorrida;
    private LocalDateTime horarioChegada;
    private boolean avaliado;

    public Corrida(int idCorrida, Veiculo veiculo, Ponto pontoInicial, Ponto pontoFinal, Passageiro passageiro, int qtdPassageiros, double precoCorrida, LocalDateTime horarioChegada, boolean avaliado) {
        this.idCorrida = idCorrida;
        this.veiculo = veiculo;
        this.pontoInicial = pontoInicial;
        this.pontoFinal = pontoFinal;
        this.passageiro = passageiro;
        this.qtdPassageiros = qtdPassageiros;
        this.precoCorrida = precoCorrida;
        this.horarioChegada = horarioChegada;
        this.avaliado = avaliado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corrida corrida = (Corrida) o;
        return idCorrida == corrida.idCorrida;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCorrida);
    }

}

