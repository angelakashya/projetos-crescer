package br.com.cwi.crescer.melevaai.controllers.request;

import br.com.cwi.crescer.melevaai.domain.Categoria;
import br.com.cwi.crescer.melevaai.domain.CorVeiculo;
import br.com.cwi.crescer.melevaai.domain.MarcaVeiculo;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

    @Setter
    @Getter
    public class VeiculoRequest {

        @NotEmpty
        private String placa;

        private MarcaVeiculo marca;

        private String modelo;

        private int ano;

        private CorVeiculo cor;

        private String foto;

        private Categoria categoria;

        private int quantidadeLugares;

        private String cpfMotorista;

        public String getCpfMotorista() {
            return this.cpfMotorista;
        }
    }


