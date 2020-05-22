package com.sid.Fort.AnalyseOperation.ChatVulProduct.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.sid.Fort.Products.Entity.Products;
import com.sid.Fort.Scenarios.Entity.Scenarios;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(indexes = {@Index(columnList="products_id",name = "IDX_products"), @Index(columnList="id_Scenario",name = "IDX_scenarios"), @Index(columnList="operation",name = "IDX_operation")})
public class ChatVulProduct implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String textProducts;
    private Double vulnerabiliteFinale;
    private Double vulnerabiliteInherente;

    private Long operation;
    private Long id_Scenario;
    @Transient
    private String NameScenario;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @javax.persistence.OrderBy(value = "id asc ")
    private Products products;

    public ChatVulProduct() {
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }
    @JsonSetter
    public void setId(Long id) {
        this.id = id;
    }


    public String getTextProducts() {
        return textProducts;
    }

    public void setTextProducts(String textProducts) {
        this.textProducts = textProducts;
    }

    public Double getVulnerabiliteFinale() {
        return vulnerabiliteFinale;
    }

    public void setVulnerabiliteFinale(Double vulnerabiliteFinale) {
        this.vulnerabiliteFinale = vulnerabiliteFinale;
    }
    @JsonIgnore
    public Long getOperation() {
        return operation;
    }
    @JsonSetter
    public void setOperation(Long operation) {
        this.operation = operation;
    }

    @JsonIgnore
        public Products getProducts() {
        return products;
    }
    @JsonSetter
    public void setProducts(Products products) {
        this.products = products;
    }
    @JsonIgnore
    public Long getId_Scenario() {
        return id_Scenario;
    }
    @JsonIgnore

    public void setId_Scenario(Long id_Scenario) {
        this.id_Scenario = id_Scenario;
    }

    public Double getVulnerabiliteInherente() {
        return vulnerabiliteInherente;
    }

    public void setVulnerabiliteInherente(Double vulnerabiliteInherente) {
        this.vulnerabiliteInherente = vulnerabiliteInherente;
    }

    public String getNameScenario() {
        return NameScenario;
    }

    public void setNameScenario(String nameScenario) {
        NameScenario = nameScenario;
    }

    @Override
    public String toString() {
        return "ChatVulProduct{" +
                "id=" + id +
                ", textProducts='" + textProducts + '\'' +
                ", vulnerabiliteFinale=" + vulnerabiliteFinale +
                ", vulnerabiliteInherente=" + vulnerabiliteInherente +
                ", operation=" + operation +
                ", id_Scenario=" + id_Scenario +
                ", NameScenario='" + NameScenario + '\'' +
                ", products=" + products +
                '}';
    }
}
