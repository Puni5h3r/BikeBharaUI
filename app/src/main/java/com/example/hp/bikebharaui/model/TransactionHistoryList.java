package com.example.hp.bikebharaui.model;

public class TransactionHistoryList {
    private String name;
    private String phoneNumber;
    private String timeDate;
    private String amount;
    private String depositeRide;

    public TransactionHistoryList() {
    }

    public TransactionHistoryList(String name, String phoneNumber, String timeDate, String amount, String depositeRide) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.timeDate = timeDate;
        this.amount = amount;
        this.depositeRide = depositeRide;
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

    public String getDepositeRide() {
        return depositeRide;
    }
    public void setDepositeRide(String n){
        this.depositeRide=n;
    }

}
