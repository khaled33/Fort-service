package com.sid.Fort.Responses.Dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sid.Fort.ResponsesGroups.Dao.ResponsesGroups;

import javax.persistence.*;
import java.io.Serializable;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

@Entity
public class Responses implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private double value;


    @ManyToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.PERSIST)
    @JoinColumn(name ="responsegrp_id" ,nullable = false)
    @JsonBackReference
    private ResponsesGroups responsesGroups;

    public Responses() {
    }

    public Responses(Long id, String text, ResponsesGroups responsesGroups,double value) {
        this.id = id;
        this.text = text;
        this.value=value;
        this.responsesGroups = responsesGroups;
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
