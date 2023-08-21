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
    @NotNull @Min(value = 1700) @Max(value = 2023)
    private Integer ano;
    @NotEmpty(message = " Gentileza informar a descrição do veículo")
    private String descricao;
    @NotNull @PositiveOrZero
    private Float preco;
    @NotEmpty(message = " Gentileza informar o chassi do veículo")
    private String chassi;
    private Boolean vendido;
    private Date updated;

    public VeiculoFormUpdate(){}

}
