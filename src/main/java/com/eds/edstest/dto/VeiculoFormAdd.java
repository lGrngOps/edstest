package com.eds.edstest.dto;

import com.eds.edstest.entities.Veiculos;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Date;

@Data
public class VeiculoFormAdd {

    @NotBlank(message = " Gentileza informar a marca do veículo")
    private String marca;
    @NotBlank(message = " Gentileza informar o modelo do veículo")
    private String veiculo;
    //@NotBlank(message = " Gentileza informar o ano de fabricação do veículo")
    @NotNull
    private Integer ano;
    @NotBlank(message = " Gentileza informar a descrição do veículo")
    private String descricao;
    //@NotBlank(message = " Gentileza informar o valor do veículo")
    @NotNull
    private Float preco;
    @NotBlank(message = " Gentileza informar o chassi do veículo")
    private String chassi;
    private Boolean vendido;
    private Date created;
    private Date updated;

    public VeiculoFormAdd(){}

}
