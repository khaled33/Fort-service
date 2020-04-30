package com.sid.Fort.ResponsesGroups.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sid.Fort.Responses.Entity.Responses;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

@Entity
public class ResponsesGroups implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    @javax.persistence.OrderBy(value = "value desc ")
    @OneToMany(mappedBy = "responsesGroups", fetch = FetchType.LAZY,cascade = CascadeType.ALL
    )
    private List<Responses> responses;

    public ResponsesGroups() {
    }

    public ResponsesGroups(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Responses> getResponses() {
        return responses;
    }

    public void setResponses(List<Responses> responses) {
        this.responses = responses;
    }
}
