package com.eds.edstest.dto;

import com.eds.edstest.entities.Veiculos;

import java.util.Date;

public class VeiculoDTO {

    private Integer id;
    private String marca;
    private String veiculo;
    private Integer ano;
    private String descricao;
    private Float preco;
    private String chassi;
    private Boolean vendido;
    private Date created;
    private Date updated;

    public VeiculoDTO(){
    }

    public VeiculoDTO(Veiculos entity){
        this.id = entity.getId();
        this.marca = entity.getMarca();
        this.veiculo = entity.getVeiculo();
        this.ano =  entity.getAno();
        this.descricao = entity.getDescricao();
        this.preco = entity.getPreco();
        this.chassi = entity.getChassi();
        this.vendido = entity.getVendido();
        this.created = entity.getCreated();
        this.updated = entity.getUpdated();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Boolean getVendido() {
        return vendido;
    }

    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
