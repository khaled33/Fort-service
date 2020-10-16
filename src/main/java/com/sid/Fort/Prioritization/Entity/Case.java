package com.sid.Fort.Prioritization.Entity;

public class Case {
    private String question;
    private Double value_reponse;
    private Double wieghts;
    private Double prerequisites;

    public Case() {
    }

    public Case(String question, Double value_reponse, Double wieghts) {
        this.question = question;
        this.value_reponse = value_reponse;
        this.wieghts = wieghts;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Double getValue_reponse() {
        return value_reponse;
    }

    public void setValue_reponse(Double value_reponse) {
        this.value_reponse = value_reponse;
    }

    public Double getWieghts() {
        return wieghts;
    }

    public void setWieghts(Double wieghts) {
        this.wieghts = wieghts;
    }

    public Double getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(Double prerequisites) {
        this.prerequisites = prerequisites;
    }

    @Override
    public String toString() {
        return "Case{" +
                "question='" + question + '\'' +
                ", value_reponse=" + value_reponse +
                ", wieghts=" + wieghts +
                '}';
    }


}
