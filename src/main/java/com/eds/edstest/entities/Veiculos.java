package com.eds.edstest.entities;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "veiculos")
    public class Veiculos {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String marca;
        private String veiculo;
        private Integer ano;
        private String descricao;
        private Float preco;
        private String chassi;
        private Boolean vendido;
        @Column(name = "criado")
        private Date created;
        @Column(name = "atualizado")
        private Date updated;

        public Veiculos() {

        }

        public Veiculos(Integer id, String marca, String veiculo, Integer ano, String descricao, Float preco, String chassi, Boolean vendido, Date created, Date updated) {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Veiculos veiculos = (Veiculos) o;
            return chassi.equals(veiculos.chassi);
        }

        @Override
        public int hashCode() {
            return Objects.hash(chassi);
        }
    }
