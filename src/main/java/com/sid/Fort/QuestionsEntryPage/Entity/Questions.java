package com.sid.Fort.QuestionsEntryPage.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sid.Fort.DnfbpsSectors.Entity.DnfbpsSectors;
import com.sid.Fort.QuestionsWeights.Entity.QuestionsWeights;
import com.sid.Fort.ResponsesGroups.Entity.ResponsesGroups;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "QuestionsEntryPage")
public class Questions implements Serializable {
    public enum Type {
         ENTRY_PAGE_TYPE, INTERMEDIATE_VARIABLE_TYPE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Transient
    private Long respSelected;
    private Integer indx;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<DnfbpsSectors> secteur;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "responsegrp_id")
    private ResponsesGroups responsesGroups;


      @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
       private QuestionsWeights questionsWeights;

    public Questions() {
    }

    public Questions(String text, ResponsesGroups responsesGroups) {
        this.text = text;
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

    public List<DnfbpsSectors> getSecteur() {
        return secteur;
    }

    public void setSecteur(List<DnfbpsSectors> secteur) {
        this.secteur = secteur;
    }

    public ResponsesGroups getResponsesGroups() {
        return responsesGroups;
    }

    public void setResponsesGroups(ResponsesGroups responsesGroups) {
        this.responsesGroups = responsesGroups;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

     public QuestionsWeights getQuestionsWeights() {
            return questionsWeights;
        }

        public void setQuestionsWeights(QuestionsWeights questionsWeights) {
            this.questionsWeights = questionsWeights;
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
}
