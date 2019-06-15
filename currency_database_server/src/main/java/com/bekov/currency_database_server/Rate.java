package com.bekov.currency_database_server;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rate {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String date;

    @Column
    private String code;

    @Column
    private double value;

    public Rate(String date, String code, double value) {
        this.date = date;
        this.code = code;
        this.value = value;
    }

    public Rate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Rate{" +
                " date=" + date +
                ", code='" + code + '\'' +
                ", value=" + value +
                '}';
    }
}
