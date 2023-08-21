package com.eds.edstest.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "veiculos")
    public class Veiculos {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String marca;
        private String veiculo;
        private Integer ano;
        private String descricao;
        private Float preco;
        @Column(unique = true, nullable = false)
        private String chassi;
        private Boolean vendido;
        private Date created;
        private Date updated;

        public Veiculos() {

        }

        public Veiculos(Long id, String marca, String veiculo, Integer ano, String descricao, Float preco, String chassi, Boolean vendido, Date created, Date updated) {
            this.id = id;
            this.marca = marca;
            this.veiculo = veiculo;
            this.ano = ano;
            this.descricao = descricao;
            this.preco = preco;
            this.chassi = chassi;
            this.vendido = vendido;
            this.created = created;
            this.updated = updated;
        }
}
