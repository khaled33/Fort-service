package com.sid.Fort.Products.Dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sid.Fort.DnfbpsSectors.Dao.DnfbpsSectors;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class Products implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name ="profession_id")
     private DnfbpsSectors dnfbpsSectors;

    public Products() {
    }

    public Products(Long id, String label) {
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

    public DnfbpsSectors getDnfbpsSectors() {
        return dnfbpsSectors;
    }

    public void setDnfbpsSectors(DnfbpsSectors dnfbpsSectors) {
        this.dnfbpsSectors = dnfbpsSectors;
    }
}
