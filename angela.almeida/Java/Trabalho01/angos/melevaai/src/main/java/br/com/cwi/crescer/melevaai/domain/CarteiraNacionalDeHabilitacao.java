package br.com.cwi.crescer.melevaai.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

    public class CarteiraNacionalDeHabilitacao {

        @NotEmpty(message="Este campo não pode estar vazio")
        private int numero;
        private Categoria categoria;

        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDate dataVencimento;

        public CarteiraNacionalDeHabilitacao(int numero, Categoria categoria, LocalDate dataVencimento) {
            this.numero = numero;
            this.categoria = categoria;
            this.dataVencimento = dataVencimento;
        }

        public CarteiraNacionalDeHabilitacao() {
        }


        public int getNumero() {
            return numero;
        }

        public Categoria getCategoria() {
            return categoria;
        }

        public LocalDate getDataVencimento() {
            return dataVencimento;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        @JsonIgnore
        public boolean isVencida() {
            return dataVencimento.isBefore(LocalDate.now());
        }


        public void setCategoria(Categoria categoria) {
            this.categoria = categoria;
        }

        public void setDataVencimento(LocalDate dataVencimento) {
            this.dataVencimento = dataVencimento;
        }
    }
