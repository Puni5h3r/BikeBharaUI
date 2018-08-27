package com.example.hp.bikebharaui.model;

public class RideHistoryList {
    private String name;
    private String phoneNumber;
    private String timeDate;

    public RideHistoryList() {
    }

    public RideHistoryList(String name, String phoneNumber, String timeDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.timeDate = timeDate;
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
}
