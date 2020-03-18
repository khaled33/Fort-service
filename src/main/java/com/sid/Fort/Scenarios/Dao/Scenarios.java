package com.sid.Fort.Scenarios.Dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sid.Fort.Operations.Dao.Operations;
import com.sid.Fort.Questions.Dao.Questions;
import com.sid.Fort.QuestionsResponsesScenarios.Dao.QuestionsResponsesScenarios;
import com.sid.Fort.QuestionsWeights.Dao.QuestionsWeights;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Scenarios implements Serializable {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Temporal(TemporalType.DATE)
    private Date datefin;
    private String designation;

    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST )
    @JsonBackReference
    @JoinColumn(name ="operation_id")
    private Operations operations;



 /*   @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JsonBackReference("QuestionsWeights")
    private List<QuestionsWeights> QuestionsWeights;*/

    public Operations getOperations() {
        return operations;
    }

    public void setOperations(Operations operations) {
        this.operations = operations;
    }

    public Scenarios() {
    }

    public Scenarios(Long id, Date datedebut, Date datefin, String designation) {
        this.id = id;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.designation = designation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

/*    public List<com.sid.Fort.QuestionsWeights.Dao.QuestionsWeights> getQuestionsWeights() {
        return QuestionsWeights;
    }

    public void setQuestionsWeights(List<com.sid.Fort.QuestionsWeights.Dao.QuestionsWeights> questionsWeights) {
        QuestionsWeights = questionsWeights;
    }*/
}
