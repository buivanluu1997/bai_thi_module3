package com.example.bai_thi_module3.model;

public class RentalRooms {
    private int id;
    private String tenantName;
    private String phoneNumber;
    private String starDate;
    private String notes;
    private int paymentId;

    public RentalRooms() {
    }

    public RentalRooms(int id, String tenantName, String phoneNumber, String starDate, String notes, int paymentId) {
        this.id = id;
        this.tenantName = tenantName;
        this.phoneNumber = phoneNumber;
        this.starDate = starDate;
        this.notes = notes;
        this.paymentId = paymentId;
    }

    public RentalRooms(String tenantName, String phoneNumber, String starDate, String notes, int paymentId) {
        this.tenantName = tenantName;
        this.phoneNumber = phoneNumber;
        this.starDate = starDate;
        this.notes = notes;
        this.paymentId = paymentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
}
