package com.example.hp.bikebharaui;

import com.google.firebase.database.DatabaseReference;

import java.util.UUID;

public class InsertData {
 // private int insertUserCount=1;
 // private int insertRideCount=8;


    public void depositMoneyInsertData(DatabaseReference databaseReference,String name, String phnNumber, String time,String id,String amount,String transferType){
      //  this.insertRideCount++;
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

            //String k = Integer.toString(insertRideCount);
           String k="Ride History User"+randomUUIDString;
            databaseReference.child(k).child("name").setValue(name);
            databaseReference.child(k).child("phone number").setValue(phnNumber);
            databaseReference.child(k).child("time").setValue(time);
            databaseReference.child(k).child("id").setValue(id);
            databaseReference.child(k).child("transfer type").setValue(transferType);
            databaseReference.child(k).child("amount").setValue(amount);
            databaseReference.child(k).child("user type").setValue("Passenger");

    }

//    public void deposithistoryInsertData(DatabaseReference databaseReference,String name, String phnNumber, String time,String amount){
//        insertcount++;
//
//        String k = Integer.toString(depositHistoryCount);
//        k="Deposit History User"+k;
//
//        databaseReference.child(k).child("name").setValue(name);
//        databaseReference.child(k).child("phone number").setValue(phnNumber);
//        databaseReference.child(k).child("time").setValue(time);
//        databaseReference.child(k).child("amount").setValue(amount);
//        databaseReference.child(k).child("id").setValue(depositHistoryCount);
//
//    }

//    public void transactionhistoryInsertData(DatabaseReference databaseReference,String name, String phnNumber, String time,String amount,String rideORDEPOSIT){
//        insertcount++;
//
//        String k = Integer.toString(transactionHistoryCount);
//        k="Transaction History User"+k;
//
//        databaseReference.child(k).child("name").setValue(name);
//        databaseReference.child(k).child("phone number").setValue(phnNumber);
//        databaseReference.child(k).child("time").setValue(time);
//        databaseReference.child(k).child("amount").setValue(amount);
//        databaseReference.child(k).child("rideORdeposit").setValue(rideORDEPOSIT);
//        databaseReference.child(k).child("id").setValue(transactionHistoryCount);
//
//    }
//    public void logRideInsertData(DatabaseReference databaseReference,String name, String phnNumber, String time){
//        insertcount++;
//
//        String k = Integer.toString(insertcount);
//        k="Ride History User"+k;
//
//        databaseReference.child(k).child("name").setValue(name);
//        databaseReference.child(k).child("phone number").setValue(phnNumber);
//        databaseReference.child(k).child("time").setValue(time);
//        databaseReference.child(k).child("id").setValue(insertcount);
//
//
//    }


    public void addUser(DatabaseReference databaseReference, String password, String name, String phoneNumber) {


        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();


        String k = randomUUIDString;
        k="User"+k;

        databaseReference.child(k).child("user name").setValue(name);
        databaseReference.child(k).child("phone number").setValue(phoneNumber);
        databaseReference.child(k).child("id").setValue(randomUUIDString);
        databaseReference.child(k).child("user type").setValue("Passenger");
        databaseReference.child(k).child("password").setValue(password);
        databaseReference.child(k).child("email").setValue(name+"@gmail.com");


    }
}
