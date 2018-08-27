package com.example.hp.bikebharaui;

public class UserManagementList {
    private String name;
    private String phoneNumber;
    private String transactionHistory;

    public UserManagementList() {
    }

    public UserManagementList(String name, String phoneNumber, String transactionHistory) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.transactionHistory = transactionHistory;

    }

    public String getName() {
        return name;
    }





    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(String transactionHistory) {
        this.transactionHistory = transactionHistory;
    }



}

