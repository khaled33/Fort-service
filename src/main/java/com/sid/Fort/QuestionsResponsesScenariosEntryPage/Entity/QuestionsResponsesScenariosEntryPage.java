package com.sid.Fort.QuestionsResponsesScenariosEntryPage.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sid.Fort.Products.Entity.Products;
import com.sid.Fort.QuestionsEntryPage.Entity.Questions;
import com.sid.Fort.Responses.Entity.Responses;
import com.sid.Fort.Scenarios.Entity.Scenarios;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity(name = "QuestionsResponsesScenariosEntryPage")

public class QuestionsResponsesScenariosEntryPage implements Serializable {
    private Double value;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Long responses_sel;


    @ManyToOne (fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name ="question_id" )
    @javax.persistence.OrderBy(value = "indx desc ")
    private Questions questions;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name ="response_id" )
    private Responses responses;



    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name ="scenario_id")
    private Scenarios scenarios;

    public QuestionsResponsesScenariosEntryPage() {
    }

    public QuestionsResponsesScenariosEntryPage(Long id, double value, double best_value) {
        this.id = id;
        this.value = value;

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
