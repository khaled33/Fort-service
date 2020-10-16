package com.sid.Fort.Prioritization.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sid.Fort.Scenarios.Entity.Scenarios;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Prioritization")
public class PrioritizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String Question;
    @JsonIgnore
    private Double PrioritizatioValues;
    private int rank;
    @ManyToOne
    @JsonIgnore
    private Scenarios scenarios;

    public PrioritizationEntity() {
    }

    public PrioritizationEntity(String question, Double prioritizatioValues) {
        Question = question;
        PrioritizatioValues = prioritizatioValues;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public Double getPrioritizatioValues() {
        return PrioritizatioValues;
    }

    public void setPrioritizatioValues(Double prioritizatioValues) {
        PrioritizatioValues = prioritizatioValues;
    }

    public Scenarios getScenarios() {
        return scenarios;
    }

    public void setScenarios(Scenarios scenarios) {
        this.scenarios = scenarios;
    }

    @Override
    public String toString() {
        return "PrioritizationEntity{" +
                "Question='" + Question + '\'' +
                ", PrioritizatioValues=" + PrioritizatioValues +
                ", rank=" + rank +
                '}';
    }
}
