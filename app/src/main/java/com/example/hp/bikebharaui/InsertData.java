package com.example.hp.bikebharaui;

import com.google.firebase.database.DatabaseReference;

import java.util.UUID;

public class InsertData {
    //A class made for inserting data, to be called anytime during the project.



    public void depositMoneyInsertData(DatabaseReference databaseReference,String name, String phnNumber, String time,String id,String amount,String transferType){
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();


           String k=phnNumber;
           k=k+randomUUIDString;
            databaseReference.child(k).child("name").setValue(name);
            databaseReference.child(k).child("phone number").setValue(phnNumber);
            databaseReference.child(k).child("time").setValue(time);
            databaseReference.child(k).child("id").setValue(id);
            databaseReference.child(k).child("transfer type").setValue(transferType);
            databaseReference.child(k).child("amount").setValue(amount);
            databaseReference.child(k).child("user type").setValue("Passenger");

    }


    public void addUser(DatabaseReference databaseReference, String password, String name, String phoneNumber,String keyValue) {


        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();


        String k = randomUUIDString;


        databaseReference.child(k).child("user name").setValue(name);
        databaseReference.child(k).child("phone number").setValue(phoneNumber);
        databaseReference.child(k).child("id").setValue(keyValue);
        databaseReference.child(k).child("user type").setValue("Passenger");
        databaseReference.child(k).child("password").setValue(password);



    }
}
