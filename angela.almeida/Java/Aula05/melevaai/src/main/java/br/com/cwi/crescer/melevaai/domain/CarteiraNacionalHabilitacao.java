package br.com.cwi.crescer.melevaai.domain;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CarteiraNacionalHabilitacao {

    private String numero;

    private Categoria categoria;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVencimento;

    @JsonIgnore
    public boolean isVencida() {
        return dataVencimento.isBefore(LocalDate.now());
    }
}
