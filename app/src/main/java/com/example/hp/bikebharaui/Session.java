package com.example.hp.bikebharaui;

public class Session {
    private static boolean userType;
    private static String passengerid;
    private static String riderid;
    private static String riderName;
    private static String passengerName;
    private static String passengerphnNumber;
    private static String riderPhnNumber;

    //This is a static class which holds the data during session,
    // and helps to transfer data at anytime of the project

    public static boolean getUserType() {
        return userType;
    }



    public static void setUserType(String userType) {
        if(userType!=null){
            if(userType.equals("Passenger")){
                Session.userType = true;
            }else{
                Session.userType = false;
            }
        }

    }

    public static String getRiderName() {
               return riderName;
    }

    public static void setRiderName(String name) {
        Session.riderName = name;
    }

    public static String getRiderid() {

        return riderid;
    }

    public static void setRiderId(String id) {

        Session.riderid = id;
    }

    public static String getRiderPhnNumber() {

        return riderPhnNumber;
    }

    public static void setRiderPhnNumber(String phnNumber)
    {

        Session.riderPhnNumber = phnNumber;
    }

    public static String getPassengerid() {
        return passengerid;
    }

    public static void setPassengerid(String passengerid) {
        Session.passengerid = passengerid;
    }

    public static String getPassengerName() {
        return passengerName;
    }

    public static void setPassengerName(String passengerName) {
        Session.passengerName = passengerName;
    }

    public static String getPassengerphnNumber() {
        return passengerphnNumber;
    }

    public static void setPassengerphnNumber(String passengerphnNumber) {
        Session.passengerphnNumber = passengerphnNumber;
    }
}
