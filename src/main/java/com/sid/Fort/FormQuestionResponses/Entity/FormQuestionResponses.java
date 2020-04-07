package com.sid.Fort.FormQuestionResponses.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sid.Fort.ResponsesGroups.Entity.ResponsesGroups;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name="FormQuestionResponses")
public class FormQuestionResponses implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private double value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="responsegrp_id")
    private ResponsesGroups responsesGroups;

    public FormQuestionResponses() {
    }

    public FormQuestionResponses(Long id, String text, double value) {
        this.id = id;
        this.text = text;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public ResponsesGroups getResponsesGroups() {
        return responsesGroups;
    }

    public void setResponsesGroups(ResponsesGroups responsesGroups) {
        this.responsesGroups = responsesGroups;
    }
}
