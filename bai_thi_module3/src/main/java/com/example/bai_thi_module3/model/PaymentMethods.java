package com.example.bai_thi_module3.model;

public class PaymentMethods {
    private int id;
    private String name;

    public PaymentMethods() {
    }

    public PaymentMethods(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
