package com.sid.Fort.Form.Entity;

import java.math.BigInteger;

public class DTODoughnutChart {
    private String x;
    private String question;
    private  Integer value;

    public DTODoughnutChart() {
    }

    public DTODoughnutChart(String index, Integer value,String question) {
        this.x = index;
        this.value = value;
        this.question = question;
    }



    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public  Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
