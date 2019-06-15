package com.bekov.currencywebserver;

import java.time.LocalDate;

public class Rate {
    private String date;
    private String code;
    private double value;


    public Rate(String date, String code, double value) {
        this.date = date;
        this.code = code;
        this.value = value;
    }

    public Rate() {
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

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Rates{" +
                "date=" + date +
                ", code='" + code + '\'' +
                ", value=" + value +
                '}';
    }
}
