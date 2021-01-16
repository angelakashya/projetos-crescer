package br.com.cwi.crescer.melevaai.domain;


import java.time.LocalDate;

    public class CarteiraNacionalDeHabilitacao {
        private int numero;
        private Categoria categoria;
        private LocalDate dataVencimento;

        public CarteiraNacionalDeHabilitacao(int numero, Categoria categoria, LocalDate dataVencimento) {
            this.numero = numero;
            this.categoria = categoria;
            this.dataVencimento = dataVencimento;
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

        public void setCategoria(Categoria categoria) {
            this.categoria = categoria;
        }

        public void setDataVencimento(LocalDate dataVencimento) {
            this.dataVencimento = dataVencimento;
        }
    }
