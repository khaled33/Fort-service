package com.sid.Fort.CountriesDetails.Dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sid.Fort.Operations.Dao.Operations;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class CountrieDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer pib;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="operation_id" ,nullable = true)
    private Operations operations;

    public CountrieDetails() {
    }

    public CountrieDetails(int pib) {
        this.pib = pib;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPib() {
        return pib;
    }


    public void setPib(Integer pib) {
        this.pib = pib;
    }

    public Operations getOperations() {
        return operations;
    }

    public void setOperations(Operations operations) {
        this.operations = operations;
    }
}
