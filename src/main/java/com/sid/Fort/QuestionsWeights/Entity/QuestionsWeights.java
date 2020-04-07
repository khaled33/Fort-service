package com.sid.Fort.QuestionsWeights.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sid.Fort.QuestionsEntryPage.Entity.Questions;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class QuestionsWeights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private int weight;
    @Column(columnDefinition = "TINYINT(1)")
    private Boolean prerequisite;

//    @ManyToOne(fetch = FetchType.LAZY,optional = false)
//    @JoinColumn(name ="question_id" ,nullable = false)
//    @JsonBackReference
//    private QuestionsEntryPage questions;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinColumn(name ="parent_id" ,nullable = false)
    private List<Questions> parent_id;



    public QuestionsWeights() {

    }
    public QuestionsWeights(Long id, int weight, Boolean prerequisite) {
        this.id = id;
        this.weight = weight;
        this.prerequisite = prerequisite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Boolean getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Boolean prerequisite) {
        this.prerequisite = prerequisite;
    }

    public List<Questions> getParent_id() {
        return parent_id;
    }

    public void setParent_id(List<Questions> parent_id) {
        this.parent_id = parent_id;
    }
}
