package com.example.hp.bikebharaui.model;

public class LogRideList {
    private String name;
    private String phoneNumber;
    private String timeDate;
    private String logRideId;

    public LogRideList() {
    }

    public LogRideList(String name, String phoneNumber, String timeDate) {
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

    public String getLogRideId() {
        return logRideId;
    }

    public void setLogRideId(String logRideId) {
        this.logRideId = logRideId;
    }
}
