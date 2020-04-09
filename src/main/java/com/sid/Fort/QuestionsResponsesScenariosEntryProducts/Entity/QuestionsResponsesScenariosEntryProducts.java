package com.sid.Fort.QuestionsResponsesScenariosEntryProducts.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sid.Fort.Products.Entity.Products;
import com.sid.Fort.QuestionsEntryPage.Entity.Questions;
import com.sid.Fort.QuestionsEntyProduct.Entity.QuestionsEntryProducts;
import com.sid.Fort.Responses.Entity.Responses;
import com.sid.Fort.Scenarios.Entity.Scenarios;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class QuestionsResponsesScenariosEntryProducts implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Double value;
    private Double CorrespondingScore;

    @Transient
    private Long responses_sel;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    @javax.persistence.OrderBy(value = "indx desc ")
    private QuestionsEntryProducts questionsEntryProducts;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "response_id")
    private Responses responses;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "scenario_id")
    private Scenarios scenarios;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private Products products;


    public QuestionsResponsesScenariosEntryProducts() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }


    public void setValue(Double value) {
        this.value = value;
    }


    public QuestionsEntryProducts getQuestionsEntryProducts() {
        return questionsEntryProducts;
    }

    public void setQuestionsEntryProducts(QuestionsEntryProducts questionsEntryProducts) {
        this.questionsEntryProducts = questionsEntryProducts;
    }

    public Responses getResponses() {
        return responses;
    }

    public void setResponses(Responses responses) {
        this.responses = responses;
    }


    public Scenarios getScenarios() {
        return scenarios;
    }

    public void setScenarios(Scenarios scenarios) {
        this.scenarios = scenarios;
    }

    public Long getResponses_sel() {
        return responses_sel;
    }

    public void setResponses_sel(Long responses_sel) {
        this.responses_sel = responses_sel;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Double getCorrespondingScore() {
        return CorrespondingScore;
    }

    public void setCorrespondingScore(Double correspondingScore) {
        CorrespondingScore = correspondingScore;
    }
}
