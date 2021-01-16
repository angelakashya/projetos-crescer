package br.com.cwi.crescer.melevaai.domain;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Ponto {
    @NotNull
    private int coordenadaX;
    @NotNull
    private int coordenadaY;

    public Ponto(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }
}

