package com.sid.Fort.DnfbpsSectors.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "Sectors")
public class DnfbpsSectors implements Serializable {
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public enum Type {
        FINANCIAL_SERVICE, SERVICE_NO_FINANCIER;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String image;
    @Enumerated(EnumType.STRING)
    private Type type;
    private boolean typeProduct;

    public DnfbpsSectors() {
    }

    public DnfbpsSectors(Long id, String designation, Type type) {
        this.id = id;
        this.designation = designation;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;

    }

    public boolean isTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(boolean typeProduct) {
        this.typeProduct = typeProduct;
    }
}

