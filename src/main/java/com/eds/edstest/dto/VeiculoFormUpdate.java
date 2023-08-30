package com.eds.edstest.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class VeiculoFormUpdate {

    @NotEmpty(message = " Gentileza informar a marca do veículo")
    private String marca;
    @NotEmpty(message = " Gentileza informar o modelo do veículo")
    private String veiculo;
    @NotNull @Min(value = 1700) @Max(value = 2023) //RN003
    private Integer ano;
    @NotEmpty(message = " Gentileza informar a descrição do veículo")
    private String descricao;
    @NotNull @PositiveOrZero //RN002
    private Float preco;
    @NotEmpty(message = " Gentileza informar o chassi do veículo")
    private String chassi;
    @NotNull
    private Boolean vendido;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date updated;

    public VeiculoFormUpdate(){}

}
