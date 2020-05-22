package com.sid.Fort.Operations.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sid.Fort.Countries.Entity.Countrie;
import com.sid.Fort.DnfbpsSectors.Entity.DnfbpsSectors;
import com.sid.Fort.Scenarios.Entity.Scenarios;
import com.sid.Fort.UserDetails.Entity.AppUser;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(indexes = {@Index(columnList="id",name = "IDX_id")})

public class Operations implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String username;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date_debut;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Countrie countrie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profession_id")
    private DnfbpsSectors dnfbpsSectors;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AppUser_id")
    private AppUser appUser;

//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "initial_case_id")
//    private Scenarios initial_case;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "last_case_id")
//    private Scenarios last_case_id;

    @JsonManagedReference
    @javax.persistence.OrderBy(value = "id desc ")
    @OneToMany(mappedBy = "operations", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Scenarios> scenarios;

    public Operations() {
    }

    public Operations(Long id, String designation, Date date_debut, Date date_fin) {
        this.id = id;
        this.designation = designation;
        this.date_debut = date_debut;
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

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }


    public Countrie getCountrie() {
        return countrie;
    }

    public void setCountrie(Countrie countrie) {
        this.countrie = countrie;
    }

    public DnfbpsSectors getDnfbpsSectors() {
        return dnfbpsSectors;
    }

    public void setDnfbpsSectors(DnfbpsSectors dnfbpsSectors) {
        this.dnfbpsSectors = dnfbpsSectors;
    }

//    public Scenarios getInitial_case() {
//        return initial_case;
//    }
//
//    public void setInitial_case(Scenarios initial_case) {
//        this.initial_case = initial_case;
//    }

//    public Scenarios getLast_case_id() {
//        return last_case_id;
//    }
//
//    public void setLast_case_id(Scenarios last_case_id) {
//        this.last_case_id = last_case_id;
//    }

    public Set<Scenarios> getScenarios() {
        return scenarios;
    }

    public void setScenarios(Set<Scenarios> scenarios) {
        this.scenarios = scenarios;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
