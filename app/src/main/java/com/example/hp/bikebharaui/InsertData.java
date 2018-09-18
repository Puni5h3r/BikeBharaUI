package com.example.hp.bikebharaui;

import com.google.firebase.database.DatabaseReference;

public class InsertData {
    private int rideHistoryCount=6;
    private int depositHistoryCount=3;
    private int transactionHistoryCount=3;


    public void ridehistoryInsertData(DatabaseReference databaseReference,String name, String phnNumber, String time){
        rideHistoryCount++;

            String k = Integer.toString(rideHistoryCount);
            k="Ride History User"+k;

            databaseReference.child(k).child("name").setValue(name);
            databaseReference.child(k).child("phone number").setValue(phnNumber);
            databaseReference.child(k).child("time").setValue(time);
            databaseReference.child(k).child("id").setValue(rideHistoryCount);

    }

    public void deposithistoryInsertData(DatabaseReference databaseReference,String name, String phnNumber, String time,String amount){
        depositHistoryCount++;

        String k = Integer.toString(depositHistoryCount);
        k="Deposit History User"+k;

        databaseReference.child(k).child("name").setValue(name);
        databaseReference.child(k).child("phone number").setValue(phnNumber);
        databaseReference.child(k).child("time").setValue(time);
        databaseReference.child(k).child("amount").setValue(amount);
        databaseReference.child(k).child("id").setValue(depositHistoryCount);

    }

    public void transactionhistoryInsertData(DatabaseReference databaseReference,String name, String phnNumber, String time,String amount,String rideORDEPOSIT){
        transactionHistoryCount++;

        String k = Integer.toString(transactionHistoryCount);
        k="Transaction History User"+k;

        databaseReference.child(k).child("name").setValue(name);
        databaseReference.child(k).child("phone number").setValue(phnNumber);
        databaseReference.child(k).child("time").setValue(time);
        databaseReference.child(k).child("amount").setValue(amount);
        databaseReference.child(k).child("rideORdeposit").setValue(rideORDEPOSIT);
        databaseReference.child(k).child("id").setValue(transactionHistoryCount);

    }


}
