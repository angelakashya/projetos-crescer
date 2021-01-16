package br.com.cwi.crescer.melevaai.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Veiculo {

    @NotEmpty
    private String placa;

    @NotNull
    private Marca marca;

    @NotEmpty
    private String modelo;

    @NotNull
    private int ano;

    @NotNull
    private Cor cor;

    private String foto;

    private int quantidadeLugares;

    @NotNull
    private Categoria categoria;

    @Valid
    @NotNull
    private Motorista proprietario;
}

