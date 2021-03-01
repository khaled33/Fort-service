package com.sid.Fort.Form.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Document
public class FormEntity implements Serializable {
    @Id
    private String id;
    private Map<String, String> Reponse;
    private String typeForm;
    private String idUser;

    public FormEntity() {
    }

    public String getId() {
        return id;
    }

    public String getTypeForm() {
        return typeForm;
    }

    public void setTypeForm(String typeForm) {
        this.typeForm = typeForm;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getReponse() {
        return Reponse;
    }

    public void setReponse(Map<String, String> reponse) {
        Reponse = reponse;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "FormEntity{" +
                "Reponse=" + Reponse +
                '}';
    }
}
