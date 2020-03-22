package com.sid.Fort.QuestionsResponsesScenarios.Dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sid.Fort.Products.Dao.Products;
import com.sid.Fort.Questions.Dao.Questions;
import com.sid.Fort.Responses.Dao.Responses;
import com.sid.Fort.Scenarios.Dao.Scenarios;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class QuestionsResponsesScenarios implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double value;
    private Double best_value;
    @Transient
    private Long responses_sel;


    @ManyToOne (fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name ="question_id" )
    @javax.persistence.OrderBy(value = "Ordre desc ")
    private Questions questions;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name ="response_id" )
    private Responses responses;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name ="products_id" )
    private Products products;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name ="scenario_id")
    @JsonBackReference
    private Scenarios scenarios;

    public QuestionsResponsesScenarios() {
    }

    public QuestionsResponsesScenarios(Long id, double value, double best_value) {
        this.id = id;
        this.value = value;
        this.best_value = best_value;
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

    public void setValue(double value) {
        this.value = value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getBest_value() {
        return best_value;
    }

    public void setBest_value(Double best_value) {
        this.best_value = best_value;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public Responses getResponses() {
        return responses;
    }

    public void setResponses(Responses responses) {
        this.responses = responses;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
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
}
