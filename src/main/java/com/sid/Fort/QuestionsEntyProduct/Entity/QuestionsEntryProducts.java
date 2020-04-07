package com.sid.Fort.QuestionsEntyProduct.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sid.Fort.DnfbpsSectors.Entity.DnfbpsSectors;
import com.sid.Fort.Products.Entity.Products;
import com.sid.Fort.QuestionsEntryPage.Entity.Questions;
import com.sid.Fort.QuestionsWeights.Entity.QuestionsWeights;
import com.sid.Fort.ResponsesGroups.Entity.ResponsesGroups;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public  class QuestionsEntryProducts implements Serializable {
    public enum Type {
        ENTRY_PRODUCT_TYPE, OTHER_VULNERABLE_PRODUCT

    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String text;
    @Transient
    private Long respSelected;
    private Integer indx;
    @Enumerated(EnumType.STRING)
    private QuestionsEntryProducts.Type type;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<DnfbpsSectors> secteur;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "responsegrp_id")
    private ResponsesGroups responsesGroups;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private QuestionsWeights questionsWeights;



    public QuestionsEntryProducts(String text, Long respSelected, Integer indx, ResponsesGroups responsesGroups, Products products) {
        this.text = text;
        this.respSelected = respSelected;
        this.indx = indx;
        this.responsesGroups = responsesGroups;
    }

    public QuestionsEntryProducts() {
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

    public Long getRespSelected() {
        return respSelected;
    }

    public void setRespSelected(Long respSelected) {
        this.respSelected = respSelected;
    }

    public Integer getIndx() {
        return indx;
    }

    public void setIndx(Integer indx) {
        this.indx = indx;
    }

    public ResponsesGroups getResponsesGroups() {
        return responsesGroups;
    }

    public void setResponsesGroups(ResponsesGroups responsesGroups) {
        this.responsesGroups = responsesGroups;
    }

    public QuestionsWeights getQuestionsWeights() {
        return questionsWeights;
    }

    public void setQuestionsWeights(QuestionsWeights questionsWeights) {
        this.questionsWeights = questionsWeights;
    }

    public List<DnfbpsSectors> getSecteur() {
        return secteur;
    }

    public void setSecteur(List<DnfbpsSectors> secteur) {
        this.secteur = secteur;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }



}
