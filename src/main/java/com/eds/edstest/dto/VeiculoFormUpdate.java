package com.eds.edstest.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class VeiculoFormUpdate {

    @NotEmpty(message = " Gentileza informar a marca do veículo")
    private String marca;
    @NotEmpty(message = " Gentileza informar o modelo do veículo")
    private String veiculo;
    @NotNull
    private Integer ano;
    @NotEmpty(message = " Gentileza informar a descrição do veículo")
    private String descricao;
    @NotNull
    private Float preco;
    @NotEmpty(message = " Gentileza informar o chassi do veículo")
    private String chassi;
    private Boolean vendido;
    private Date created;
    private Date updated;

    public VeiculoFormUpdate(){}

}
