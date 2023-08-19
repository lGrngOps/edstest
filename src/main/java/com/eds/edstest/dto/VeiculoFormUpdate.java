package com.eds.edstest.dto;

import com.eds.edstest.entities.Veiculos;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

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
    //@NotEmpty(message = " Gentileza informar o valor do veículo")
    @NotNull
    private Float preco;
    @NotEmpty(message = " Gentileza informar o chassi do veículo")
    private String chassi;
    private Boolean vendido;
    private Date created;
    private Date updated;

    public VeiculoFormUpdate(){}

}
