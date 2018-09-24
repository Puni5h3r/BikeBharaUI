package com.example.hp.bikebharaui;

public class Session {
    private static boolean userType;
    private static String id;
    private static String name;
    private static String phnNumber;

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

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Session.name = name;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Session.id = id;
    }

    public static String getPhnNumber() {
        return phnNumber;
    }

    public static void setPhnNumber(String phnNumber) {
        Session.phnNumber = phnNumber;
    }
}
