package com.sid.Fort.Countries.Dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name ="Countries" )
public class Countrie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 2)
    @NotNull(message = "country_code is required")
    private String country_code;
    @Size(max = 100)
    @NotNull(message = "country_name is required")
    private String country_name;
    @Size(max = 250)
    private String flag;

    public Countrie() {
    }

    public Countrie(@Size(max = 2) String country_code, @Size(max = 100) String country_name, @Size(max = 250) String flag) {
        this.country_code = country_code;
        this.country_name = country_name;
        this.flag = flag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
