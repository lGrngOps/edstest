package com.eds.edstest.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class VeiculoFormAdd {

    @NotBlank(message = " Gentileza informar a marca do veículo")
    private String marca;
    @NotBlank(message = " Gentileza informar o modelo do veículo")
    private String veiculo;
    @NotNull
    private Integer ano;
    @NotBlank(message = " Gentileza informar a descrição do veículo")
    private String descricao;
    @NotNull
    private Float preco;
    @NotBlank(message = " Gentileza informar o chassi do veículo")
    private String chassi;
    private Boolean vendido;
    private Date created;
    private Date updated;

    public VeiculoFormAdd(){}

}
