package com.example.hp.bikebharaui.model;

public class DepositeHistoryList {
    private String name;
    private String phoneNumber;
    private String timeDate;
    private String amount;

    public DepositeHistoryList() {
    }

    public DepositeHistoryList(String name, String phoneNumber, String timeDate, String amount) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.timeDate = timeDate;
        this.amount = amount;
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


    public String getTimeDate() {
        return timeDate;
    }
    public void setTimeDate(String n){
        this.timeDate=n;
    }


    public String getAmount() {
        return amount;
    }
    public void setAmount(String n){
        this.amount=n;
    }

}
