package com.sid.Fort.Scenarios.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sid.Fort.Operations.Entity.Operations;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(indexes = {@Index(columnList="id",name = "IDX_id"), @Index(columnList="operation_id",name = "IDX_operations")})
public class Scenarios implements Serializable {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date datedebut;

    private String designation;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
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

    public Scenarios(Long id, Date datedebut,  String designation) {
        this.id = id;
        this.datedebut = datedebut;
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



    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

/*    public List<com.sid.Fort.QuestionsWeights.Entity.QuestionsWeights> getQuestionsWeights() {
        return QuestionsWeights;
    }

    public void setQuestionsWeights(List<com.sid.Fort.QuestionsWeights.Entity.QuestionsWeights> questionsWeights) {
        QuestionsWeights = questionsWeights;
    }*/
}
