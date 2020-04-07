package com.sid.Fort.UserDetails.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
@Entity(name = "User")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class AppUser implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private Date created;
    private Date modified;
    private Date lastlogin;
    private Date expiry;
    private String language;
    private int timezone;
    private int timeformat;
    private int dateformat;
    private String password;
    @Column(unique = true)
//    @Email(regexp=".@.\\..*", message = "Email should be valid")
    private String email;
    @Column(nullable = false, columnDefinition = "TINYINT(1)",precision = 1)
    private Boolean enable;
    private String mobilephone;
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<Role> roles=new ArrayList<>();

    public AppUser() {
    }

    public AppUser(String firstname, String lastname, Date created, Date modified, Date lastlogin, Date expiry, String language, int timezone, int timeformat, int dateformat, String password, String email, Boolean enable, String mobilephone, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.created = created;
        this.modified = modified;
        this.lastlogin = lastlogin;
        this.expiry = expiry;
        this.language = language;
        this.timezone = timezone;
        this.timeformat = timeformat;
        this.dateformat = dateformat;
        this.password = password;
        this.email = email;
        this.enable = enable;
        this.mobilephone = mobilephone;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getTimeformat() {
        return timeformat;
    }

    public void setTimeformat(int timeformat) {
        this.timeformat = timeformat;
    }

    public int getDateformat() {
        return dateformat;
    }

    public void setDateformat(int dateformat) {
        this.dateformat = dateformat;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }
    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
