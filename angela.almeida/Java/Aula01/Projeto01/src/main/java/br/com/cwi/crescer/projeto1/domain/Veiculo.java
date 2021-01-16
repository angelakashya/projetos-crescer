package br.com.cwi.crescer.projeto1.domain;

import br.com.cwi.crescer.projeto1.exception.MotoristaComCNHVencidaException;
import br.com.cwi.crescer.projeto1.exception.MotoristaNaoHabilitadoException;
import br.com.cwi.crescer.projeto1.exception.ProprietarioObrigatorioException;

import java.awt.color.ProfileDataException;
import java.time.LocalDate;

public class Veiculo {

    private String placa;
    private MarcaVeiculo marca;
    private String modelo;
    private int ano;
    private CorVeiculo cor;
    private String foto;
    private Categoria categoria;
    private int quantidadeLugares;
    private Motorista proprietario;

    public Veiculo(String placa, MarcaVeiculo marca, String modelo, int ano, CorVeiculo cor, String foto, Categoria categoria, int quantidadeLugares, Motorista proprietario) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.foto = foto;
        this.categoria = categoria;
        this.quantidadeLugares = quantidadeLugares;
        this.proprietario = proprietario;

        verificarProprietario();
        verificarCategoria();
        verificarValidadeCnh();
    }

    public String getPlaca() {
        return placa;
    }

    public MarcaVeiculo getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public CorVeiculo getCor() {
        return cor;
    }

    public String getFoto() {
        return foto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getQuantidadeLugares() {
        return quantidadeLugares;
    }

    public Motorista getProprietario() {
        return proprietario;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(MarcaVeiculo marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCor(CorVeiculo cor) {
        this.cor = cor;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setQuantidadeLugares(int quantidadeLugares) {
        this.quantidadeLugares = quantidadeLugares;
    }

    public void setProprietario(Motorista proprietario) {
        this.proprietario = proprietario;
    }

    public void verificarProprietario() {
        if(getProprietario() == null)
            throw new ProprietarioObrigatorioException();
    }

    public void verificarCategoria() {
        if(proprietario.getCnh().getCategoria() != categoria)
            throw new MotoristaNaoHabilitadoException();
    }

    public void verificarValidadeCnh() {
        if(proprietario.getCnh().getDataVencimento() != LocalDate.now())
            throw new MotoristaComCNHVencidaException();
    }
}
