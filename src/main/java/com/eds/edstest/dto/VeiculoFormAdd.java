package com.eds.edstest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Date;

@Data
public class VeiculoFormAdd {

    //@NotBlank(message = " Gentileza informar a marca do veículo")
    private String marca;
    //@NotBlank(message = " Gentileza informar o modelo do veículo")
    private String veiculo;
    //@PastOrPresent @NotBlank(message = " Gentileza informar o ano de fabricação do veículo")
    private Integer ano;
    //@NotBlank(message = " Gentileza informar a descrição do veículo")
    private String descricao;
    //@Positive @NotBlank(message = " Gentileza informar o valor do veículo")
    private Float preco;
    //@UniqueElements @NotBlank(message = " Gentileza informar o chassi do veículo")
    private String chassi;
    //@NotBlank(message = " Informar situação de venda do veiculo")
    private Boolean vendido;
    private Date created;
    private Date updated;

}
