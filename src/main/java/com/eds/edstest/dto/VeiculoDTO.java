package com.eds.edstest.dto;

import com.eds.edstest.entities.Veiculos;
import lombok.Data;

import java.util.Date;

@Data
public class VeiculoDTO {

    private Long id;
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

    public VeiculoDTO(Veiculos veiculos){
        this.id = veiculos.getId();
        this.marca = veiculos.getMarca();
        this.veiculo = veiculos.getVeiculo();
        this.ano =  veiculos.getAno();
        this.descricao = veiculos.getDescricao();
        this.preco = veiculos.getPreco();
        this.chassi = veiculos.getChassi();
        this.vendido = veiculos.getVendido();
        this.created = veiculos.getCreated();
        this.updated = veiculos.getUpdated();
    }
}
