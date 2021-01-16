package br.com.cwi.crescer.melevaai.controllers.response;

import br.com.cwi.crescer.melevaai.domain.Categoria;
import br.com.cwi.crescer.melevaai.domain.CorVeiculo;
import br.com.cwi.crescer.melevaai.domain.MarcaVeiculo;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoResponse {

    private String placa;

    private MarcaVeiculo marca;

    private String modelo;

    private int ano;

    private CorVeiculo cor;

    private String foto;

    private Categoria categoria;

    private int quantidadeLugares;

    private Motorista proprietario;
}

