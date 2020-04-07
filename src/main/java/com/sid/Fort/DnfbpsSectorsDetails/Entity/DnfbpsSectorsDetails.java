package com.sid.Fort.DnfbpsSectorsDetails.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sid.Fort.Operations.Entity.Operations;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class DnfbpsSectorsDetails  implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number_total;
    private int number_region;
    private int number_per_type;
    private double turnover;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="operation_id")
    private Operations operations;

    public DnfbpsSectorsDetails() {
    }

    public DnfbpsSectorsDetails(Long id, int number_total, int number_region, int number_per_type, double turnover) {
        this.id = id;
        this.number_total = number_total;
        this.number_region = number_region;
        this.number_per_type = number_per_type;
        this.turnover = turnover;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber_total() {
        return number_total;
    }

    public void setNumber_total(int number_total) {
        this.number_total = number_total;
    }

    public int getNumber_region() {
        return number_region;
    }

    public void setNumber_region(int number_region) {
        this.number_region = number_region;
    }

    public int getNumber_per_type() {
        return number_per_type;
    }

    public void setNumber_per_type(int number_per_type) {
        this.number_per_type = number_per_type;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    public Operations getOperations() {
        return operations;
    }

    public void setOperations(Operations operations) {
        this.operations = operations;
    }
}
